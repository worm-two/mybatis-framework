package cn.ming.mybatis;

import java.util.List;

/**
 * @Author: xuming
 * @Date: 2023-07-08 13:46
 * @Version: 1.0
 * @Description: 会话接口
 **/
public interface SqlSession {

    <T> T selectOne(String statement);

    <T> T selectOne(String statement, Object parameter);

    <T> List<T> selectList(String statement);

    <T> List<T> selectList(String statement, Object parameter);

    void close();
}
