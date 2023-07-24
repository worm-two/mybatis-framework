package cn.ming.mybatis.scripting;

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

    SqlSource createSqlSource(Configuration configuration, Element script, Class<?> parameterType);

}