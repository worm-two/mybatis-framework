package cn.ming.mybatis;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @Author: xuming
 * @Date: 2023-07-09 13:19
 * @Version: 1.0
 * @Description: 映射器（Mapper接口）代理类
 **/
@AllArgsConstructor
public class MapperProxy<T> implements InvocationHandler, Serializable {


    private static final long serialVersionUID = 8284280270259075939L;

    private Map<String, String> sqlSession;

    private final Class<T> mapperInterface;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(this, args);
        } else {
            return "你的Mapper接口被代理了!" + sqlSession.get(mapperInterface.getName() + "." + method.getName());
        }
    }
}
