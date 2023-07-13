package cn.ming.mybatis.session.defaults;

import cn.ming.mybatis.mapping.MappedStatement;
import cn.ming.mybatis.session.Configuration;
import cn.ming.mybatis.session.SqlSession;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

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
        return (T) ("你的操作被代理了！" + statement);
    }


    @Override
    public <T> T selectOne(String statement, Object parameter) {
        MappedStatement mappedStatement = configuration.getMappedStatement(statement);
        return (T) ("你的操作被代理了！" + "\n方法：" + statement + "\n入参：" + parameter + "\n待执行SQL：" + mappedStatement.getSql());
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

}
