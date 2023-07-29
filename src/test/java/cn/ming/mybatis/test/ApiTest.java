package cn.ming.mybatis.test;

import cn.ming.mybatis.test.dao.IActivityDao;
import cn.ming.mybatis.test.po.Activity;
import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: xuming
 * @Date: 2023-07-29 11:25
 * @Version: 1.0
 * @Description: 单元测试
 **/
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_ClassPathXmlApplicationContext() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");
        IActivityDao dao = beanFactory.getBean("IActivityDao", IActivityDao.class);
        Activity res = dao.queryActivityById(new Activity(100001L));
        logger.info("测试结果：{}", JSON.toJSONString(res));
    }

}