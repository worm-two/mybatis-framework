package cn.ming.mybatis;

/**
 * @Author: xuming
 * @Date: 2023-07-08 16:31
 * @Version: 1.0
 * @Description: 会话工厂接口
 **/
public interface SqlSessionFactory {

    SqlSession openSession();
}
