package cn.ming.mybatis.executor.resultset;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @Author: xuming
 * @Date: 2023-07-16 12:22
 * @Version: 1.0
 * @Description: 结果集处理器
 **/
public interface ResultSetHandler {

    <E> List<E> handleResultSets(Statement statement) throws SQLException;
}
