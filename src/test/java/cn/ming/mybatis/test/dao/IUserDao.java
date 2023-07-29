package cn.ming.mybatis.test.dao;

import cn.ming.mybatis.test.po.User;

/**
 * @Author: xuming
 * @Date: 2023-07-29 11:35
 * @Version: 1.0
 * @Description: TODO
 **/
public interface IUserDao {

    User queryUserInfoById(Long uId);

}
