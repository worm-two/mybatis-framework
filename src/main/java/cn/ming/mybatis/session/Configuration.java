package cn.ming.mybatis.session;

import cn.ming.mybatis.binding.MapperRegistry;
import cn.ming.mybatis.datasource.druid.DruidDataSourceFactory;
import cn.ming.mybatis.mapping.Environment;
import cn.ming.mybatis.mapping.MappedStatement;
import cn.ming.mybatis.transaction.jdbc.JdbcTransactionFactory;
import cn.ming.mybatis.type.TypeAliasRegistry;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xuming
 * @Date: 2023-07-08 16:29
 * @Version: 1.0
 * @Description: 配置项
 **/
@Setter
public class Configuration {

    protected Environment environment;

    /**
     * 映射注册机
     */
    protected MapperRegistry mapperRegistry = new MapperRegistry(this);

    /**
     * 映射的语句，存在Map里
     */
    protected final Map<String, MappedStatement> mappedStatements = new HashMap<>();

    protected final TypeAliasRegistry typeAliasRegistry = new TypeAliasRegistry();

    public Configuration() {
        typeAliasRegistry.registerAlias("JDBC", JdbcTransactionFactory.class);
        typeAliasRegistry.registerAlias("DRUID", DruidDataSourceFactory.class);
    }

    public void addMappers(String packageName) {
        mapperRegistry.addMappers(packageName);
    }

    public <T> void addMapper(Class<T> Type) {
        mapperRegistry.addMapper(Type);
    }

    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        return this.mapperRegistry.getMapper(type, sqlSession);
    }

    public boolean hasMapper(Class<?> type) {
        return mapperRegistry.hasMapper(type);
    }

    public void addMappedStatement(MappedStatement mappedStatement) {
        mappedStatements.put(mappedStatement.getId(), mappedStatement);
    }

    public MappedStatement getMappedStatement(String id) {
        return mappedStatements.get(id);
    }


    public TypeAliasRegistry getTypeAliasRegistry() {
        return typeAliasRegistry;
    }

    public Environment getEnvironment() {
        return environment;
    }
}
