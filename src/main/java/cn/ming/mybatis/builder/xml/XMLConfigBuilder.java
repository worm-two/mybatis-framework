package cn.ming.mybatis.builder.xml;

import cn.ming.mybatis.builder.BaseBuilder;
import cn.ming.mybatis.io.Resources;
import cn.ming.mybatis.mapping.MappedStatement;
import cn.ming.mybatis.mapping.SqlCommandType;
import cn.ming.mybatis.session.Configuration;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.InputSource;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: xuming
 * @Date: 2023-07-13 20:53
 * @Version: 1.0
 * @Description: XML配置构建器，建造者模式，继承BaseBuilder
 **/
@Slf4j
public class XMLConfigBuilder extends BaseBuilder {

    public static final String MAPPERS = "mappers";
    public static final String MAPPER = "mapper";

    public static final String RESOURCE = "resource";

    public static final String NAMESPACE = "namespace";

    public static final String ID = "id";

    public static final String PARAMETER_TYPE = "parameterType";

    public static final String RESULT_TYPE = "resultType";

    public static final String SELECT = "select";

    public static final String UPDATE = "update";

    public static final String INSERT = "insert";

    public static final String DELETE = "delete";


    private Element root;

    public XMLConfigBuilder(Reader reader) {
        // 1.调用父类初始化Configuration
        super(new Configuration());
        // 2.do4j处理xml
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(new InputSource(reader));
            root = document.getRootElement();
        } catch (DocumentException e) {
            log.error("error:", e);
        }
    }

    // 解析配置；类型别名、插件、对象工厂、对象包装工厂、设置、环境、类型转换、映射器
    public Configuration parse() {
        try {
            // 解析mapper映射器
            mapperElement(root.element(MAPPERS));
        } catch (Exception e) {
            throw new RuntimeException("Error parsing SQL Mapper Configuration. Cause: " + e, e);
        }
        return configuration;
    }

    private void mapperElement(Element mappers) throws Exception {
        List<Element> mapperList = mappers.elements(MAPPER);
        for (Element element : mapperList) {
            String resource = element.attributeValue(RESOURCE);
            Reader reader = Resources.getResourcesAsReader(resource);
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(new InputSource(reader));
            Element root = document.getRootElement();
            // 命名空间
            String namespace = root.attributeValue(NAMESPACE);
            // SELECT
            List<Element> selectNodes = root.elements(SELECT);
            for (Element node : selectNodes) {
                String id = node.attributeValue(ID);
                String parameterType = node.attributeValue(PARAMETER_TYPE);
                String resultType = node.attributeValue(RESULT_TYPE);
                String sql = node.getText();

                // ?匹配
                Map<Integer, String> parameter = new HashMap<>();
                Pattern pattern = Pattern.compile("(#\\{(.*?)})");
                Matcher matcher = pattern.matcher(sql);
                for (int i = 1; matcher.find(); i++) {
                    String g1 = matcher.group(1);
                    String g2 = matcher.group(2);
                    parameter.put(i, g2);
                    sql = sql.replace(g1, "?");
                }

                String msId = namespace + "." + id;
                String nodeName = node.getName();
                SqlCommandType sqlCommandType = SqlCommandType.valueOf(nodeName.toUpperCase(Locale.ENGLISH));
                MappedStatement mappedStatement = new MappedStatement().builder()
                        .configuration(configuration)
                        .id(msId)
                        .sqlCommandType(sqlCommandType)
                        .parameter(parameter)
                        .parameterType(parameterType)
                        .resultType(resultType)
                        .sql(sql)
                        .build();
                // 添加解析SQL
                configuration.addMappedStatement(mappedStatement);
            }
            // 注册Mapper映射器
            configuration.addMapper(Resources.classForName(namespace));
        }
    }

}
