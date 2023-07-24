package cn.ming.mybatis.executor;

import cn.ming.mybatis.mapping.BoundSql;
import cn.ming.mybatis.mapping.MappedStatement;
import cn.ming.mybatis.session.ResultHandler;
import cn.ming.mybatis.transaction.Transaction;
import cn.ming.mybatis.session.RowBounds;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: xuming
 * @Date: 2023-07-16 12:25
 * @Version: 1.0
 * @Description: 执行器
 **/
public interface Executor {

    ResultHandler NO_RESULT_HANDLER = null;

    <E> List<E> query(MappedStatement ms, Object parameter, RowBounds rowBounds, ResultHandler resultHandler, BoundSql boundSql);

    Transaction getTransaction();

    void commit(boolean required) throws SQLException;

    void rollback(boolean required) throws SQLException;

    void close(boolean forceRollback);

}