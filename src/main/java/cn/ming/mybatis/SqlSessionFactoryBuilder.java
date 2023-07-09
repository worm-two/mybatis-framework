package cn.ming.mybatis;

import lombok.extern.slf4j.Slf4j;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.InputSource;

import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @Author: xuming
 * @Date: 2023-07-08 16:32
 * @Version: 1.0
 * @Description: session工厂建造者
 **/
@Slf4j
public class SqlSessionFactoryBuilder {


    public DefaultSqlSessionFactory build(Reader reader) {
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(new InputSource(reader));
            Configuration configuration = parseConfiguration(document.getRootElement());
            return new DefaultSqlSessionFactory(configuration);
        } catch (Exception e) {
            log.error("exception:", e);
        }
        return null;
    }

    private Configuration parseConfiguration(Element root) {
        Configuration configuration = new Configuration();
        configuration.setDatabase(dataSource(root.selectNodes("//dataSource")));
        configuration.setConnection(connection(configuration.database));
        configuration.setMapperElement(mapperElement(root.selectNodes("//mappers")));
        return configuration;
    }

    private Map<String, String> dataSource(List<Element> list) {
        Map<String, String> dataSource = new HashMap<>(4);

        Element element = list.get(0);
        List content = element.content();
        for (Object o : content) {
            Element e = (Element) o;
            String name = e.attributeValue("name");
            String value = e.attributeValue("value");
            dataSource.put(name, value);
        }

        return dataSource;
    }

    private Connection connection(Map<String, String> dataSource) {
        try {
            Class.forName(dataSource.get("driver"));
            return DriverManager.getConnection(dataSource.get("url"), dataSource.get("username"), dataSource.get("password"));
        } catch (Exception e) {
            log.error("exception:", e);
        }
        return null;
    }

    private Map<String, XNode> mapperElement(List<Element> list) {
        Map<String, XNode> map = new HashMap<>();
        Element element = list.get(0);
        List content = element.content();
        for (Object o : content) {
            Element e = (Element) o;
            String resource = e.attributeValue("resource");
            try {
                Reader reader = Resources.getResourcesAsReader(resource);
                SAXReader saxReader = new SAXReader();
                Document document = saxReader.read(new InputSource(reader));

                Element root = document.getRootElement();
                // 命名空间
                String namespace = root.attributeValue("namespace");
                // Select
                List<Element> selectNodes = root.selectNodes("select");
                for (Element node : selectNodes) {
                    String id = node.attributeValue("id");
                    String parameterType = node.attributeValue("parameterType");
                    String resultType = node.attributeValue("resultType");
                    String sql = node.getText();
                    // ？匹配
                    Map<Integer, String> parameter = new HashMap<>();
                    Pattern pattern = Pattern.compile("(#\\{(.*?)})");
                    Matcher matcher = pattern.matcher(sql);
                    for (int i = 0; matcher.find(); i++) {
                        String g1 = matcher.group(1);
                        String g2 = matcher.group(2);
                        parameter.put(i, g2);
                        sql = sql.replace(g1, "?");
                    }

                    XNode xNode = new XNode();
                    xNode.setNamespace(namespace);
                    xNode.setSql(sql);
                    xNode.setId(id);
                    xNode.setParameterType(parameterType);
                    xNode.setResultType(resultType);
                    xNode.setParameter(parameter);

                    map.put(namespace + "." + id, xNode);
                }
            } catch (Exception ex) {
                log.error("exception:", ex);
            }
        }
        return map;
    }

}
