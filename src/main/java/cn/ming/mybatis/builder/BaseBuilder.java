package cn.ming.mybatis.builder;

import cn.ming.mybatis.session.Configuration;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: xuming
 * @Date: 2023-07-13 20:54
 * @Version: 1.0
 * @Description: 构建器的基类，建造者模式
 **/
@AllArgsConstructor
@Getter
public abstract class BaseBuilder {

    protected final Configuration configuration;
}
