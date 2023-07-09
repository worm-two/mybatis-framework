package cn.ming.mybatis;

import cn.ming.mybatis.entity.User;
import cn.ming.mybatis.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

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

    @Test
    public void mapperProxy() {
        MapperProxyFactory<UserMapper> factory = new MapperProxyFactory<>(UserMapper.class);

        Map<String,String> sqlSession =new HashMap<>();
        sqlSession.put("cn.ming.mybatis.mapper.UserMapper.queryUserName", "模拟执行查询操作");
        sqlSession.put("cn.ming.mybatis.mapper.UserMapper.queryUserAge", "模拟执行查询操作");

        UserMapper userMapper = factory.newInstance(sqlSession);
        String name = userMapper.queryUserName("10001");
        System.out.println("name = " + name);

    }
}
