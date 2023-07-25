package cn.ming.mybatis.test.dao;


import cn.ming.mybatis.test.po.Activity;

public interface IActivityDao {

    Activity queryActivityById(Long activityId);

}
