package cn.ming.mybatis.test;


import cn.ming.mybatis.io.Resources;
import cn.ming.mybatis.session.SqlSession;
import cn.ming.mybatis.session.SqlSessionFactory;
import cn.ming.mybatis.session.SqlSessionFactoryBuilder;
import cn.ming.mybatis.test.dao.IActivityDao;
import cn.ming.mybatis.test.po.Activity;
import com.alibaba.fastjson.JSON;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    private SqlSession sqlSession;

    @BeforeEach
    public void init() throws IOException {
        // 1. 从SqlSessionFactory中获取SqlSession
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config-datasource.xml"));
        sqlSession = sqlSessionFactory.openSession();
    }

    @Test
    public void test_queryActivityById() {
        // 1. 获取映射器对象
        IActivityDao dao = sqlSession.getMapper(IActivityDao.class);
        // 2. 测试验证
        Activity res = dao.queryActivityById(100001L);
        System.out.println("res = " + res);
        logger.info("测试结果：{}", JSON.toJSONString(res));
    }



}
