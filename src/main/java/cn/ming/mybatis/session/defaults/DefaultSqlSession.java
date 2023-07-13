package cn.ming.mybatis.session.defaults;

import cn.ming.mybatis.session.Configuration;
import cn.ming.mybatis.session.SqlSession;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
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

    private Configuration configuration;


    @Override
    public <T> T selectOne(String statement) {
        // try {
        //     XNode xNode = mapperElement.get(statement);
        //     PreparedStatement preparedStatement = connection.prepareStatement(xNode.getSql());
        //     ResultSet resultSet = preparedStatement.executeQuery();
        //     List<T> result = dealResult(resultSet, Class.forName(xNode.getResultType()));
        //     result.get(0);
        // } catch (Exception e) {
        //     log.error("Exception", e);
        // }

        return null;
    }


    @Override
    public <T> T selectOne(String statement, Object parameter) {

        return (T) ("你的操作被代理了！" + "方法：" + statement + " 入参：" + parameter);

        // XNode xNode = mapperElement.get(statement);
        // Map<Integer, String> parameterMap = xNode.getParameter();
        // try {
        //     PreparedStatement preparedStatement = connection.prepareStatement(xNode.getSql());
        //     buildParameter(preparedStatement, parameter, parameterMap);
        //     ResultSet resultSet = preparedStatement.executeQuery();
        //     List<T> list = dealResult(resultSet, Class.forName(xNode.getResultType()));
        //     return list.get(0);
        // } catch (Exception e) {
        //     log.error("error:",e);
        // }
        // return null;
    }

    @Override
    public <T> List<T> selectList(String statement) {
        // XNode xNode = mapperElement.get(statement);
        // try {
        //     PreparedStatement preparedStatement = connection.prepareStatement(xNode.getSql());
        //     ResultSet resultSet = preparedStatement.executeQuery();
        //     return dealResult(resultSet, Class.forName(xNode.getResultType()));
        // } catch (Exception e) {
        //     log.error("exception:", e);
        // }
        return null;
    }

    @Override
    public <T> List<T> selectList(String statement, Object parameter) {
        // XNode xNode = mapperElement.get(statement);
        // Map<Integer, String> parameterMap = xNode.getParameter();
        // try {
        //     PreparedStatement preparedStatement = connection.prepareStatement(xNode.getSql());
        //     buildParameter(preparedStatement, parameter, parameterMap);
        //     ResultSet resultSet = preparedStatement.executeQuery();
        //     return dealResult(resultSet, Class.forName(xNode.getResultType()));
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
        return null;
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return this.configuration.getMapper(type, this);
    }

    @Override
    public Configuration getConfiguration() {
        return this.configuration;
    }

    @Override
    public void close() {
        // if (connection == null) return;
        // try {
        //     connection.close();
        // } catch (SQLException e) {
        //     log.error("Error while closing:", e);
        // }
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
                        method = clazz.getMethod(setMethod, java.util.Date.class);
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

    private void buildParameter(PreparedStatement preparedStatement, Object parameter, Map<Integer, String> parameterMap) throws Exception {
        int size = parameterMap.size();
        // 单个参数
        if (parameter instanceof Long) {
            for (int i = 1; i <= size; i++) {
                preparedStatement.setLong(i, Long.parseLong(parameter.toString()));
            }
            return;
        }

        if (parameter instanceof Integer) {
            for (int i = 1; i <= size; i++) {
                preparedStatement.setInt(i, Integer.parseInt(parameter.toString()));
            }
            return;
        }

        if (parameter instanceof String) {
            for (int i = 1; i <= size; i++) {
                preparedStatement.setString(i, parameter.toString());
            }
            return;
        }

        Map<String, Object> fieldMap = new HashMap<>();
        // 对象参数
        Field[] declaredFields = parameter.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            String name = field.getName();
            field.setAccessible(true);
            Object obj = field.get(parameter);
            field.setAccessible(false);
            fieldMap.put(name, obj);
        }

        for (int i = 1; i <= size; i++) {
            String filedName = parameterMap.get(i);
            Object obj = fieldMap.get(filedName);

            if (obj instanceof Short) {
                preparedStatement.setShort(i, Short.parseShort(obj.toString()));
                continue;
            }

            if (obj instanceof Integer) {
                preparedStatement.setInt(i, Integer.parseInt(obj.toString()));
                continue;
            }

            if (obj instanceof Long) {
                preparedStatement.setLong(i, Long.parseLong(obj.toString()));
                continue;
            }

            if (obj instanceof String) {
                preparedStatement.setString(i, obj.toString());
                continue;
            }

            if (obj instanceof Date) {
                preparedStatement.setDate(i, (java.sql.Date) obj);
            }

        }
    }
}