package cn.ming.mybatis.type;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @Author: xuming
 * @Date: 2023-07-15 13:42
 * @Version: 1.0
 * @Description: 类型别名注册机
 **/
public class TypeAliasRegistry {


    private final Map<String, Class<?>> TYPE_ALIAS = new HashMap<>();

    public TypeAliasRegistry() {
        // 构造函数里注册系统内置的类型别名
        registerAlias("string", String.class);

        // 基本包装类型
        registerAlias("byte", Byte.class);
        registerAlias("long", Long.class);
        registerAlias("short", Short.class);
        registerAlias("int", Integer.class);
        registerAlias("integer", Integer.class);
        registerAlias("double", Double.class);
        registerAlias("float", Float.class);
        registerAlias("boolean", Boolean.class);
    }

    public void registerAlias(String alias, Class<?> value) {
        String key = alias.toLowerCase(Locale.ENGLISH);
        TYPE_ALIAS.put(key, value);
    }

    public <T> Class<T> resolveAlias(String alias) {
        String key = alias.toLowerCase(Locale.ENGLISH);
        return (Class<T>) TYPE_ALIAS.get(key);
    }
}
