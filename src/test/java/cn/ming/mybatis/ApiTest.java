package cn.ming.mybatis;

import cn.ming.mybatis.entity.User;
import cn.ming.mybatis.io.Resources;
import cn.ming.mybatis.mapper.UserMapper;
import cn.ming.mybatis.session.SqlSession;
import cn.ming.mybatis.session.SqlSessionFactory;
import cn.ming.mybatis.session.SqlSessionFactoryBuilder;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.Reader;

/**
 * @Author: xuming
 * @Date: 2023-07-08 13:24
 * @Version: 1.0
 * @Description: 测试手写的mybatis框架
 **/
@Slf4j
public class ApiTest {

    @Test
    public void app() throws Exception {
        // 1.从SqlSessionFactory中获取SslSession
        Reader reader = Resources.getResourcesAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 2.获取映射器对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 3.测试验证
        // User s = userMapper.queryUserInfoById(1L);
        // log.info("测试结果：{}", s);

        // 3. 测试验证
        // for (int i = 0; i < 50; i++) {
        //     System.out.println("i = " + i);
        //     User user = userMapper.queryUserInfoById(1L);
        //     log.info("测试结果：{}", JSON.toJSONString(user));
        //     System.out.println("-----------------");
        // }
    }
}
