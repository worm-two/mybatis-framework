package cn.ming.mybatis;

import cn.ming.mybatis.binding.MapperProxyFactory;
import cn.ming.mybatis.binding.MapperRegistry;
import cn.ming.mybatis.entity.User;
import cn.ming.mybatis.io.Resources;
import cn.ming.mybatis.mapper.UserMapper;
import cn.ming.mybatis.session.SqlSession;
import cn.ming.mybatis.session.SqlSessionFactory;
import cn.ming.mybatis.session.SqlSessionFactoryBuilder;
import cn.ming.mybatis.session.defaults.DefaultSqlSessionFactory;
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

        // UserMapper userMapper = factory.newInstance(sqlSession);
        // String name = userMapper.queryUserName("10001");
        // System.out.println("name = " + name);

    }

    @Test
    public void mapperRegistry() {
        MapperRegistry registry = new MapperRegistry();
        registry.addMappers("cn.ming.mybatis.mapper");

        SqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory(registry);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        String name = mapper.queryUserName("10001");
        log.info("测试结果是:{}",name);
    }
}
