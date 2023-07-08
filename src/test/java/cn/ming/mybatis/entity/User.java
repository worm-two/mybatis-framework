package cn.ming.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @Author: xuming
 * @Date: 2023-07-08 13:19
 * @Version: 1.0
 * @Description: User表的实体类
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    /**
     * 自增ID
     */
    private Long id;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 用户头像
     */
    private String userHead;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 创建时间
     */
    private LocalDate createTime;

    /**
     * 修改时间
     */
    private LocalDate updateTime;
}
