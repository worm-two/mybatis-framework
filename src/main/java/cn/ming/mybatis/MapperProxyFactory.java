package cn.ming.mybatis;

import lombok.AllArgsConstructor;

import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * @Author: xuming
 * @Date: 2023-07-09 13:29
 * @Version: 1.0
 * @Description: 映射器（Mapper接口）代理工厂
 **/
@AllArgsConstructor
public class MapperProxyFactory<T> {

    private final Class<T> mapperInterface;


    public T newInstance(Map<String, String> sqlSession) {
        final MapperProxy<T> mapperProxy = new MapperProxy<T>(sqlSession, mapperInterface);
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[]{
                mapperInterface
        }, mapperProxy);
    }
}
