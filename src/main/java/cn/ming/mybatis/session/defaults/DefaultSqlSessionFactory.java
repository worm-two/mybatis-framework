package cn.ming.mybatis.session.defaults;

import cn.ming.mybatis.Configuration;
import cn.ming.mybatis.binding.MapperRegistry;
import cn.ming.mybatis.session.SqlSession;
import cn.ming.mybatis.session.SqlSessionFactory;
import lombok.AllArgsConstructor;

/**
 * @Author: xuming
 * @Date: 2023-07-08 16:37
 * @Version: 1.0
 * @Description: 默认会话工厂
 **/
@AllArgsConstructor
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    // private final Configuration configuration;


    private final MapperRegistry mapperRegistry;

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(mapperRegistry);
    }
}
