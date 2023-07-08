package cn.ming.mybatis;

import lombok.AllArgsConstructor;

/**
 * @Author: xuming
 * @Date: 2023-07-08 16:37
 * @Version: 1.0
 * @Description: 默认会话工厂
 **/
@AllArgsConstructor
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final Configuration configuration;

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration.connection,configuration.mapperElement);
    }
}
