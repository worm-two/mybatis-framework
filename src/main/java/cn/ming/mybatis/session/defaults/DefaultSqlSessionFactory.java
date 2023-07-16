package cn.ming.mybatis.session.defaults;

import cn.ming.mybatis.executor.Executor;
import cn.ming.mybatis.mapping.Environment;
import cn.ming.mybatis.session.Configuration;
import cn.ming.mybatis.session.SqlSession;
import cn.ming.mybatis.session.SqlSessionFactory;
import cn.ming.mybatis.session.TransactionIsolationLevel;
import cn.ming.mybatis.transaction.Transaction;
import cn.ming.mybatis.transaction.TransactionFactory;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.sql.SQLException;

/**
 * @Author: xuming
 * @Date: 2023-07-08 16:37
 * @Version: 1.0
 * @Description: 默认会话工厂
 **/
@AllArgsConstructor
@Slf4j
public class DefaultSqlSessionFactory implements SqlSessionFactory {


    private final Configuration configuration;

    @Override
    public SqlSession openSession() {
        Transaction tx = null;
        try {
            final Environment environment = configuration.getEnvironment();
            TransactionFactory transactionFactory = environment.getTransactionFactory();
            tx = transactionFactory.newTransaction(configuration.getEnvironment().getDataSource(), TransactionIsolationLevel.READ_COMMITTED, false);
            // 创建执行器
            final Executor executor = configuration.newExecutor(tx);
            // 创建DefaultSqlSession
            return new DefaultSqlSession(configuration, executor);

        } catch (Exception e) {
            try {
                assert tx != null;
                tx.close();

            } catch (SQLException ignore) {
            }
            throw new RuntimeException("Error opening session.  Cause: " + e);
        }
    }
}
