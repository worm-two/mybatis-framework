package cn.ming.mybatis.entity;

import lombok.Data;

import java.util.List;

/**
 * @Author: xuming
 * @Date: 2023-07-19 21:28
 * @Version: 1.0
 * @Description: TODO
 **/
@Data
public class Teacher {

    private String name;

    private double price;

    private List<Student> students;

    private Student student;

}
