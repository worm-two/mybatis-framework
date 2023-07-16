package cn.ming.mybatis.executor.resultset;

import cn.ming.mybatis.executor.Executor;
import cn.ming.mybatis.mapping.BoundSql;
import cn.ming.mybatis.mapping.MappedStatement;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: xuming
 * @Date: 2023-07-16 12:22
 * @Version: 1.0
 * @Description: 默认Map结果处理器
 **/
@Slf4j
public class DefaultResultSetHandler implements ResultSetHandler {

    private final BoundSql boundSql;

    public DefaultResultSetHandler(Executor executor, MappedStatement mappedStatement, BoundSql boundSql) {
        this.boundSql = boundSql;
    }

    @Override
    public <E> List<E> handleResultSets(Statement statement) throws SQLException {
        ResultSet resultSet = statement.getResultSet();
        try {
            return resultMapping(resultSet, Class.forName(boundSql.getResultType()));
        } catch (Exception e) {
            log.error("error:", e);
            return null;
        }
    }

    private <T> List<T> resultMapping(ResultSet resultSet, Class<?> clazz) {
        List<T> result = new ArrayList<>();
        try {
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            while (resultSet.next()) {
                Constructor<?> constructor = clazz.getConstructor();
                T obj = (T) constructor.newInstance();
                for (int i = 1; i <= columnCount; i++) {
                    Object value = resultSet.getObject(i);
                    String columnName = metaData.getColumnName(i);
                    String setMethod = "set" + columnName.substring(0, 1).toUpperCase() + columnName.substring(1);
                    Method method;
                    if (value instanceof Timestamp) {
                        method = clazz.getMethod(setMethod, Date.class);
                    } else {
                        method = clazz.getMethod(setMethod, value.getClass());
                    }
                    method.invoke(obj, value);
                }
                result.add(obj);
            }
        } catch (Exception e) {
            log.error("error:", e);
        }
        return result;
    }
}
