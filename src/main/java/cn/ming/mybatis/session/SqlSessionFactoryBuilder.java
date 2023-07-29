package cn.ming.mybatis.session;

import cn.ming.mybatis.builder.xml.XMLConfigBuilder;
import cn.ming.mybatis.session.defaults.DefaultSqlSessionFactory;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.Document;

import java.io.Reader;


/**
 * @Author: xuming
 * @Date: 2023-07-08 16:32
 * @Version: 1.0
 * @Description: session工厂建造者
 **/
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(Reader reader) {
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(reader);
        return build(xmlConfigBuilder.parse());
    }

    public SqlSessionFactory build(Document document) {
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(document);
        return build(xmlConfigBuilder.parse());
    }

    public SqlSessionFactory build(Configuration config) {
        return new DefaultSqlSessionFactory(config);
    }

}
