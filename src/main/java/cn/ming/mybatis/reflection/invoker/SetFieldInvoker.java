package cn.ming.mybatis.reflection.invoker;

import lombok.AllArgsConstructor;

import java.lang.reflect.Field;

/**
 * @Author: xuming
 * @Date: 2023-07-19 20:31
 * @Version: 1.0
 * @Description: setter 调用者
 **/
@AllArgsConstructor
public class SetFieldInvoker implements Invoker {


    private Field field;

    @Override
    public Object invoke(Object target, Object[] args) throws Exception {
        field.set(target, args[0]);
        return null;
    }

    @Override
    public Class<?> getType() {
        return field.getType();
    }
}
