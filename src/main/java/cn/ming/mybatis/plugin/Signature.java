package cn.ming.mybatis.plugin;

/**
 * @Author: xuming
 * @Date: 2023-07-27 21:52
 * @Version: 1.0
 * @Description: 方法签名
 **/
public @interface Signature {

    /**
     * 被拦截类
     */
    Class<?> type();

    /**
     * 被拦截类的方法
     */
    String method();

    /**
     * 被拦截类的方法的参数
     */
    Class<?>[] args();

}