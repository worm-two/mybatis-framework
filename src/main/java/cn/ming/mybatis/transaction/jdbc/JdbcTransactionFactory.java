package cn.ming.mybatis.transaction.jdbc;

import cn.ming.mybatis.session.TransactionIsolationLevel;
import cn.ming.mybatis.transaction.Transaction;
import cn.ming.mybatis.transaction.TransactionFactory;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @Author: xuming
 * @Date: 2023-07-15 13:41
 * @Version: 1.0
 * @Description: JdbcTransaction工厂
 **/
public class JdbcTransactionFactory implements TransactionFactory {

    @Override
    public Transaction newTransaction(Connection connection) {
        return new JdbcTransaction(connection);
    }

    @Override
    public Transaction newTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit) {
        return new JdbcTransaction(dataSource, level, autoCommit);
    }
}
