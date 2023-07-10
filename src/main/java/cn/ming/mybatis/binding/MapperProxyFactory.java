package cn.ming.mybatis.binding;

import cn.ming.mybatis.session.SqlSession;
import lombok.AllArgsConstructor;

import java.lang.reflect.Proxy;

/**
 * @Author: xuming
 * @Date: 2023-07-09 13:29
 * @Version: 1.0
 * @Description: 映射器（Mapper接口）代理工厂
 **/
@AllArgsConstructor
public class MapperProxyFactory<T> {

    private final Class<T> mapperInterface;


    @SuppressWarnings("unchecked")
    public T newInstance(SqlSession sqlSession) {
        final MapperProxy<T> mapperProxy = new MapperProxy<>(sqlSession, mapperInterface);
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[]{mapperInterface}, mapperProxy);
    }
}
