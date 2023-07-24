package cn.ming.mybatis.mapping;

import cn.ming.mybatis.session.Configuration;
import cn.ming.mybatis.type.JdbcType;
import cn.ming.mybatis.type.TypeHandler;

/**
 * @Author: xuming
 * @Date: 2023-07-24 21:05
 * @Version: 1.0
 * @Description: 结果映射
 **/
public class ResultMapping {

    private Configuration configuration;
    private String property;
    private String column;
    private Class<?> javaType;
    private JdbcType jdbcType;
    private TypeHandler<?> typeHandler;

    ResultMapping() {
    }

    public static class Builder {
        private ResultMapping resultMapping = new ResultMapping();


    }

}
