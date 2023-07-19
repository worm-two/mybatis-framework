package cn.ming.mybatis.reflection.invoker;

/**
 * @Author: xuming
 * @Date: 2023-07-19 20:23
 * @Version: 1.0
 * @Description: 调用者
 **/
public interface Invoker {

    Object invoke(Object target,Object[] args) throws Exception;

    Class<?> getType();
}
