package cn.ming.mybatis.reflection.factory;

import java.util.List;
import java.util.Properties;

/**
 * @Author: xuming
 * @Date: 2023-07-19 19:52
 * @Version: 1.0
 * @Description: 对象工厂接口
 **/
public interface ObjectFactory {

    // 设置属性
    void setProperties(Properties properties);

    // 生产对象
    <T> T create(Class<T> type);

    // 生产对象，使用指定的构造函数和构造函数参数
    <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs);

    // 返回这个对象是否是集合
    <T> boolean isCollection(Class<T> type);
}
