package cn.ming.mybatis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author: xuming
 * @Date: 2023-07-08 13:49
 * @Version: 1.0
 * @Description: 默认会话实现类
 **/
@Data
@AllArgsConstructor
@Slf4j
public class DefaultSqlSession implements SqlSession {

    private Connection connection;

    private Map<String, XNode> mapperElement;

    @Override
    public <T> T selectOne(String statement) {
        try {
            XNode xNode = mapperElement.get(statement);
            PreparedStatement preparedStatement = connection.prepareStatement(xNode.getSql());
            ResultSet resultSet = preparedStatement.executeQuery();
            List<T> result = dealResult(resultSet, Class.forName(xNode.getParameterType()));
        } catch (Exception e) {
            log.error("Exception", e);
        }

        return null;
    }


    @Override
    public <T> T selectOne(String statement, Object parameter) {
        return null;
    }

    @Override
    public <T> List<T> selectList(Object parameter) {
        return null;
    }

    @Override
    public <T> List<T> selectList(String statement, Object parameter) {
        return null;
    }

    @Override
    public void close() {

    }

    private <T> List<T> dealResult(ResultSet resultSet, Class<?> clazz) {
        List<T> list = new ArrayList<>();
        try {
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            // 每次遍历行值
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
                list.add(obj);
            }
        } catch (Exception e) {
            log.error("Error getting:", e);
        }
        return list;
    }
}
