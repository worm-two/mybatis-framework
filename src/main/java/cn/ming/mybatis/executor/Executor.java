package cn.ming.mybatis.executor;

import cn.ming.mybatis.cache.CacheKey;
import cn.ming.mybatis.mapping.BoundSql;
import cn.ming.mybatis.mapping.MappedStatement;
import cn.ming.mybatis.session.ResultHandler;
import cn.ming.mybatis.session.RowBounds;
import cn.ming.mybatis.transaction.Transaction;

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

    int update(MappedStatement ms, Object parameter) throws SQLException;

    // 查询，含缓存
    <E> List<E> query(MappedStatement ms, Object parameter, RowBounds rowBounds, ResultHandler resultHandler, CacheKey key, BoundSql boundSql) throws SQLException;

    // 查询
    <E> List<E> query(MappedStatement ms, Object parameter, RowBounds rowBounds, ResultHandler resultHandler) throws SQLException;

    Transaction getTransaction();

    void commit(boolean required) throws SQLException;

    void rollback(boolean required) throws SQLException;

    void close(boolean forceRollback);

    // 清理Session缓存
    void clearLocalCache();

    // 创建缓存 Key
    CacheKey createCacheKey(MappedStatement ms, Object parameterObject, RowBounds rowBounds, BoundSql boundSql);

    void setExecutorWrapper(Executor executor);

}