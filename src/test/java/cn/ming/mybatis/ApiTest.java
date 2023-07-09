package cn.ming.mybatis;

import cn.ming.mybatis.entity.User;
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
    public void selectOne() throws Exception {
        String resource = "mybatis-config.xml";
        Reader reader;
        reader = Resources.getResourcesAsReader(resource);
        DefaultSqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("cn.ming.mybatis.mapper.UserMapper.queryUserInfoById", 1L);
        System.out.println("user = " + user);
        sqlSession.close();
        reader.close();
    }
}
