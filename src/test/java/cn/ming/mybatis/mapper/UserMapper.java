package cn.ming.mybatis.mapper;

import cn.ming.mybatis.entity.User;

import java.util.List;

/**
 * @Author: xuming
 * @Date: 2023-07-08 13:23
 * @Version: 1.0
 * @Description: User表Mapper接口
 **/
public interface UserMapper {

    // User queryUserInfoById(Long id);
    //
    // List<User> queryUserList(User user);
    //
    // String queryUserName(String uId);
    //
    // Integer queryUserAge(String uId);

    User queryUserInfoById(Long userId);
}
