package cn.ming.mybatis.reflection.wrapper;

import cn.ming.mybatis.reflection.MetaObject;

/**
 * @Author: xuming
 * @Date: 2023-07-19 21:04
 * @Version: 1.0
 * @Description: 默认对象包装工厂
 **/
public class DefaultObjectWrapperFactory implements ObjectWrapperFactory {

    @Override
    public boolean hasWrapperFor(Object object) {
        return false;
    }

    @Override
    public ObjectWrapper getWrapperFor(MetaObject metaObject, Object object) {
        throw new RuntimeException("The DefaultObjectWrapperFactory should never be called to provide an ObjectWrapper.");
    }
}
