package cn.ming.mybatis.scripting;

import cn.ming.mybatis.executor.parameter.ParameterHandler;
import cn.ming.mybatis.mapping.BoundSql;
import cn.ming.mybatis.mapping.MappedStatement;
import cn.ming.mybatis.mapping.SqlSource;
import cn.ming.mybatis.session.Configuration;
import org.dom4j.Element;

/**
 * @Author: xuming
 * @Date: 2023-07-24 7:32
 * @Version: 1.0
 * @Description:  脚本语言驱动
 **/
public interface LanguageDriver {

    /**
     * 创建SQL源码(mapper xml方式)
     */
    SqlSource createSqlSource(Configuration configuration, Element script, Class<?> parameterType);

    /**
     * 创建参数处理器
     */
    ParameterHandler createParameterHandler(MappedStatement mappedStatement, Object parameterObject, BoundSql boundSql);

}
