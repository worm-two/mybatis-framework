package cn.ming.mybatis.test.plugin;


import cn.ming.mybatis.executor.statement.StatementHandler;
import cn.ming.mybatis.mapping.BoundSql;
import cn.ming.mybatis.plugin.Interceptor;
import cn.ming.mybatis.plugin.Intercepts;
import cn.ming.mybatis.plugin.Invocation;
import cn.ming.mybatis.plugin.Signature;

import java.sql.Connection;
import java.util.Properties;

@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class})})
public class TestPlugin implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // 获取StatementHandler
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        // 获取SQL信息
        BoundSql boundSql = statementHandler.getBoundSql();
        String sql = boundSql.getSql();
        // 输出SQL
        System.out.println("拦截SQL：" + sql);
        // 放行
        return invocation.proceed();
    }

    @Override
    public void setProperties(Properties properties) {
        System.out.println("参数输出：" + properties.getProperty("test00"));
    }

}
