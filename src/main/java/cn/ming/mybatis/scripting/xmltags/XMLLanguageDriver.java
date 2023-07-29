package cn.ming.mybatis.scripting.xmltags;

import cn.ming.mybatis.mapping.BoundSql;
import cn.ming.mybatis.mapping.MappedStatement;
import cn.ming.mybatis.mapping.SqlSource;
import cn.ming.mybatis.scripting.LanguageDriver;
import cn.ming.mybatis.scripting.defaults.RawSqlSource;
import cn.ming.mybatis.session.Configuration;
import cn.ming.mybatis.executor.parameter.ParameterHandler;
import cn.ming.mybatis.scripting.defaults.DefaultParameterHandler;
import org.dom4j.Element;

/**
 * @Author: xuming
 * @Date: 2023-07-24 7:35
 * @Version: 1.0
 * @Description: XML语言驱动器
 **/
public class XMLLanguageDriver implements LanguageDriver {

    @Override
    public SqlSource createSqlSource(Configuration configuration, Element script, Class<?> parameterType) {
        // 用XML脚本构建器解析
        XMLScriptBuilder builder = new XMLScriptBuilder(configuration, script, parameterType);
        return builder.parseScriptNode();
    }

    /**
     * step-12 新增方法，用于处理注解配置 SQL 语句
     */
    @Override
    public SqlSource createSqlSource(Configuration configuration, String script, Class<?> parameterType) {
        // 暂时不解析动态 SQL
        return new RawSqlSource(configuration, script, parameterType);
    }

    @Override
    public ParameterHandler createParameterHandler(MappedStatement mappedStatement, Object parameterObject, BoundSql boundSql) {
        return new DefaultParameterHandler(mappedStatement, parameterObject, boundSql);
    }

}