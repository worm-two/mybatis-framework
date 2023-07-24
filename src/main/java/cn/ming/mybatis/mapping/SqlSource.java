package cn.ming.mybatis.mapping;

/**
 * @Author: xuming
 * @Date: 2023-07-24 7:33
 * @Version: 1.0
 * @Description: SQL源码
 **/
public interface SqlSource {

    BoundSql getBoundSql(Object parameterObject);

}