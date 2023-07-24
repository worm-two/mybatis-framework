package cn.ming.mybatis.builder;

import cn.ming.mybatis.mapping.BoundSql;
import cn.ming.mybatis.mapping.ParameterMapping;
import cn.ming.mybatis.mapping.SqlSource;
import cn.ming.mybatis.session.Configuration;

import java.util.List;

/**
 * @Author: xuming
 * @Date: 2023-07-24 7:45
 * @Version: 1.0
 * @Description: 静态SQL源码
 **/
public class StaticSqlSource implements SqlSource {

    private String sql;
    private List<ParameterMapping> parameterMappings;
    private Configuration configuration;

    public StaticSqlSource(Configuration configuration, String sql) {
        this(configuration, sql, null);
    }

    public StaticSqlSource(Configuration configuration, String sql, List<ParameterMapping> parameterMappings) {
        this.sql = sql;
        this.parameterMappings = parameterMappings;
        this.configuration = configuration;
    }

    @Override
    public BoundSql getBoundSql(Object parameterObject) {
        return new BoundSql(configuration, sql, parameterMappings, parameterObject);
    }

}
