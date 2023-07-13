package cn.ming.mybatis.session;

import cn.ming.mybatis.builder.xml.XMLConfigBuilder;
import cn.ming.mybatis.session.defaults.DefaultSqlSessionFactory;
import lombok.extern.slf4j.Slf4j;

import java.io.Reader;


/**
 * @Author: xuming
 * @Date: 2023-07-08 16:32
 * @Version: 1.0
 * @Description: session工厂建造者
 **/
@Slf4j
public class SqlSessionFactoryBuilder {


    public SqlSessionFactory build(Reader reader) {
        XMLConfigBuilder configBuilder = new XMLConfigBuilder(reader);
        Configuration configuration = configBuilder.parse();
        return build(configuration);

    }


    public SqlSessionFactory build(Configuration configuration) {
        return new DefaultSqlSessionFactory(configuration);
    }

}
