package cn.ming.mybatis.reflection.wrapper;

import cn.ming.mybatis.reflection.MetaObject;

/**
 * @Author: xuming
 * @Date: 2023-07-19 20:44
 * @Version: 1.0
 * @Description: 对象包装工厂
 **/
public interface ObjectWrapperFactory {

    /**
     * 判断有没有包装器
     */
    boolean hasWrapperFor(Object object);

    /**
     * 得到包装器
     */
    ObjectWrapper getWrapperFor(MetaObject metaObject, Object object);
}
