package cn.ming.mybatis.reflection.invoker;

import lombok.AllArgsConstructor;

import java.lang.reflect.Field;

/**
 * @Author: xuming
 * @Date: 2023-07-19 20:29
 * @Version: 1.0
 * @Description: getter 调用者
 **/
@AllArgsConstructor
public class GetFieldInvoker implements Invoker {

    private Field field;

    @Override
    public Object invoke(Object target, Object[] args) throws Exception {
        return field.get(target);
    }

    @Override
    public Class<?> getType() {
        return field.getType();
    }
}
