package cn.ming.mybatis.transaction;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author: xuming
 * @Date: 2023-07-15 13:41
 * @Version: 1.0
 * @Description: 事务接口
 **/
public interface Transaction {

    Connection getConnection() throws SQLException;


    void commit() throws SQLException;

    void rollback() throws SQLException;

    void close() throws SQLException;
}
