package cn.ming.mybatis.mapping;

import cn.ming.mybatis.session.Configuration;
import cn.ming.mybatis.type.JdbcType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Author: xuming
 * @Date: 2023-07-15 13:38
 * @Version: 1.0
 * @Description: 参数映射 #{property,javaType=int,jdbcType=NUMERIC}
 **/
@NoArgsConstructor
@Builder
@Getter
public class ParameterMapping {

    private Configuration configuration;

    private String property;

    private Class<?> javaType = Object.class;

    private JdbcType jdbcType;
}
