package cn.ming.mybatis.session;

/**
 * @Author: xuming
 * @Date: 2023-07-24 21:12
 * @Version: 1.0
 * @Description: 结果上下文
 **/
public interface ResultContext {

    /**
     * 获取结果
     */
    Object getResultObject();

    /**
     * 获取记录数
     */
    int getResultCount();

}