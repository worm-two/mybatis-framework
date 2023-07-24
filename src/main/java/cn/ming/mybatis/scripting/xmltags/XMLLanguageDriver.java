package cn.ming.mybatis.scripting.xmltags;

import cn.ming.mybatis.executor.parameter.ParameterHandler;
import cn.ming.mybatis.mapping.BoundSql;
import cn.ming.mybatis.mapping.MappedStatement;
import cn.ming.mybatis.mapping.SqlSource;
import cn.ming.mybatis.scripting.LanguageDriver;
import cn.ming.mybatis.scripting.defaults.DefaultParameterHandler;
import cn.ming.mybatis.session.Configuration;
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

    @Override
    public ParameterHandler createParameterHandler(MappedStatement mappedStatement, Object parameterObject, BoundSql boundSql) {
        return new DefaultParameterHandler(mappedStatement, parameterObject, boundSql);
    }

}