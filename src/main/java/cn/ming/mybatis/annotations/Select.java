package cn.ming.mybatis.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: xuming
 * @Date: 2023-07-25 20:53
 * @Version: 1.0
 * @Description: select 语句注解
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Select {

    String[] value();

}
