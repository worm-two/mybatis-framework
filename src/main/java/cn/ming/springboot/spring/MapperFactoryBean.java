package cn.ming.springboot.spring;

import cn.ming.mybatis.session.SqlSessionFactory;
import org.springframework.beans.factory.FactoryBean;

import javax.annotation.Resource;

/**
 * @Author: xuming
 * @Date: 2023-07-29 11:32
 * @Version: 1.0
 * @Description: Mapper 工厂对象
 **/
public class MapperFactoryBean<T> implements FactoryBean<T> {

    private Class<T> mapperInterface;
    @Resource
    private SqlSessionFactory sqlSessionFactory;

    public MapperFactoryBean(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    @Override
    public T getObject() throws Exception {
        return sqlSessionFactory.openSession().getMapper(mapperInterface);
    }

    @Override
    public Class<?> getObjectType() {
        return mapperInterface;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

}
