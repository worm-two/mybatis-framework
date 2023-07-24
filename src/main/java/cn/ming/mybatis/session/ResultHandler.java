package cn.ming.mybatis.session;

/**
 * @Author: xuming
 * @Date: 2023-07-16 12:26
 * @Version: 1.0
 * @Description: 结果处理器
 **/
public interface ResultHandler {

    /**
     * 处理结果
     */
    void handleResult(ResultContext context);

}
