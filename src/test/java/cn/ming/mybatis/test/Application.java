package cn.ming.mybatis.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: xuming
 * @Date: 2023-07-29 11:36
 * @Version: 1.0
 * @Description: TODO
 **/
@SpringBootApplication
@Configuration
@ComponentScan(basePackages = {"cn.ming.mybatis.*"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
