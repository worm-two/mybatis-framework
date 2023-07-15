package cn.ming.mybatis.session;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Connection;

/**
 * @Author: xuming
 * @Date: 2023-07-15 13:39
 * @Version: 1.0
 * @Description: 事务的隔离级别
 **/
@AllArgsConstructor
@Getter
public enum TransactionIsolationLevel {

    // 包括JDBC支持的5个级别

    // 没有事务
    NONE(Connection.TRANSACTION_NONE),

    // 读未提交
    READ_UNCOMMITTED(Connection.TRANSACTION_READ_UNCOMMITTED),
    // 读已提交
    READ_COMMITTED(Connection.TRANSACTION_READ_COMMITTED),
    // 可重复读
    REPEATABLE_READ(Connection.TRANSACTION_REPEATABLE_READ),
    // 串行化
    SERIALIZABLE(Connection.TRANSACTION_SERIALIZABLE);

    private final int level;
}
