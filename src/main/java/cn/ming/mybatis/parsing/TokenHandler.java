package cn.ming.mybatis.parsing;

/**
 * @Author: xuming
 * @Date: 2023-07-24 7:44
 * @Version: 1.0
 * @Description: 记号处理器
 **/
public interface TokenHandler {

    String handleToken(String content);

}
