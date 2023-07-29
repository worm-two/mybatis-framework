package cn.ming.mybatis.scripting.defaults;

import cn.ming.mybatis.session.Configuration;
import cn.ming.mybatis.builder.SqlSourceBuilder;
import cn.ming.mybatis.mapping.BoundSql;
import cn.ming.mybatis.mapping.SqlSource;
import cn.ming.mybatis.scripting.xmltags.DynamicContext;
import cn.ming.mybatis.scripting.xmltags.SqlNode;

import java.util.HashMap;

/**
 * @Author: xuming
 * @Date: 2023-07-24 7:41
 * @Version: 1.0
 * @Description: 原始SQL源码，比 DynamicSqlSource 动态SQL处理快
 **/
public class RawSqlSource implements SqlSource {

    private final SqlSource sqlSource;

    public RawSqlSource(Configuration configuration, SqlNode rootSqlNode, Class<?> parameterType) {
        this(configuration, getSql(configuration, rootSqlNode), parameterType);
    }

    public RawSqlSource(Configuration configuration, String sql, Class<?> parameterType) {
        SqlSourceBuilder sqlSourceParser = new SqlSourceBuilder(configuration);
        Class<?> clazz = parameterType == null ? Object.class : parameterType;
        sqlSource = sqlSourceParser.parse(sql, clazz, new HashMap<>());
    }

    @Override
    public BoundSql getBoundSql(Object parameterObject) {
        return sqlSource.getBoundSql(parameterObject);
    }

    private static String getSql(Configuration configuration, SqlNode rootSqlNode) {
        DynamicContext context = new DynamicContext(configuration, null);
        rootSqlNode.apply(context);
        return context.getSql();
    }

}
