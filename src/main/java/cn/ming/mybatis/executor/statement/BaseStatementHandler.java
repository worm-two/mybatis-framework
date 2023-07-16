package cn.ming.mybatis.executor.statement;

import cn.ming.mybatis.executor.Executor;
import cn.ming.mybatis.executor.resultset.ResultSetHandler;
import cn.ming.mybatis.mapping.BoundSql;
import cn.ming.mybatis.mapping.MappedStatement;
import cn.ming.mybatis.session.Configuration;
import cn.ming.mybatis.session.ResultHandler;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author: xuming
 * @Date: 2023-07-16 12:23
 * @Version: 1.0
 * @Description: 语句处理器抽象基类
 **/
@Slf4j
public abstract class BaseStatementHandler implements StatementHandler {


    protected final Configuration configuration;
    protected final Executor executor;
    protected final MappedStatement mappedStatement;

    protected final Object parameterObject;
    protected final ResultSetHandler resultSetHandler;

    protected BoundSql boundSql;

    public BaseStatementHandler(Executor executor, MappedStatement mappedStatement, Object parameterObject, ResultHandler resultHandler, BoundSql boundSql) {
        this.configuration = mappedStatement.getConfiguration();
        this.executor = executor;
        this.mappedStatement = mappedStatement;
        this.boundSql = boundSql;

        this.parameterObject = parameterObject;
        this.resultSetHandler = configuration.newResultSetHandler(executor, mappedStatement, boundSql);
    }


    @Override
    public Statement prepare(Connection connection) throws SQLException {
        Statement statement = null;
        try {
            // 实例化 Statement
            statement = instantiateStatement(connection);
            // 参数设置，可以被抽取，提供配置
            statement.setQueryTimeout(350);
            statement.setFetchSize(10000);
            return statement;
        } catch (Exception e) {
            log.error("error:", e);
            throw new RuntimeException("Error preparing statement.  Cause: " + e, e);
        }
    }

    protected abstract Statement instantiateStatement(Connection connection) throws SQLException;
}
