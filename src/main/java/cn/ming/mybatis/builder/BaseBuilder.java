package cn.ming.mybatis.builder;

import cn.ming.mybatis.session.Configuration;
import cn.ming.mybatis.type.TypeAliasRegistry;

/**
 * @Author: xuming
 * @Date: 2023-07-13 20:54
 * @Version: 1.0
 * @Description: 构建器的基类，建造者模式
 **/
public abstract class BaseBuilder {

    protected final Configuration configuration;

    protected final TypeAliasRegistry typeAliasRegistry;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
        this.typeAliasRegistry = this.configuration.getTypeAliasRegistry();
    }
}
