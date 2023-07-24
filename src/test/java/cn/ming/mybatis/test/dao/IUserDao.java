package cn.ming.mybatis.test.dao;


import cn.ming.mybatis.test.po.User;

public interface IUserDao {

    User queryUserInfoById(Long uId);

}
