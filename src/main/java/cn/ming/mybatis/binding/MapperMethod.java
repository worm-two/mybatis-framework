package cn.ming.mybatis.binding;

import cn.ming.mybatis.mapping.MappedStatement;
import cn.ming.mybatis.mapping.SqlCommandType;
import cn.ming.mybatis.session.Configuration;
import cn.ming.mybatis.session.SqlSession;
import lombok.Getter;

import java.lang.reflect.Method;

/**
 * @Author: xuming
 * @Date: 2023-07-11 7:29
 * @Version: 1.0
 * @Description: 映射器方法
 **/
public class MapperMethod {

    private final SqlCommand command;

    public MapperMethod(Class<?> mapperInterface, Method method, Configuration configuration) {
        this.command = new SqlCommand(configuration, mapperInterface, method);
    }

    public Object execute(SqlSession sqlSession, Object[] args) {
        Object result = null;
        switch (command.getType()) {
            case INSERT:
                break;
            case DELETE:
                break;
            case UPDATE:
                break;
            case SELECT:
                result = sqlSession.selectOne(command.getName(), args);
                break;
            default:
                throw new RuntimeException("unknown execution method for: " + command.getName());
        }
        return result;
    }

    /**
     * SQL 指令
     */
    @Getter
    public static class SqlCommand {

        private final String name;

        private final SqlCommandType type;

        public SqlCommand(Configuration configuration, Class<?> mapperInstance, Method method) {
            String statement = mapperInstance.getName() + "." + method.getName();
            MappedStatement mappedStatement = configuration.getMappedStatement(statement);
            this.name = mappedStatement.getId();
            this.type = mappedStatement.getSqlCommandType();
        }
    }
}
