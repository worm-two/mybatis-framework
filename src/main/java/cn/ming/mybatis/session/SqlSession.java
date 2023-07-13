package cn.ming.mybatis.session;

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
    <T> T getMapper(Class<T> type);

    Configuration getConfiguration();

    void close();
}
