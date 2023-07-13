package cn.ming.mybatis.mapping;

/**
 * @Author: xuming
 * @Date: 2023-07-11 7:31
 * @Version: 1.0
 * @Description: SQL 指令类型
 **/
public enum SqlCommandType {

    /**
     * 查询
     */
    SELECT,

    /**
     * 新增
     */
    INSERT,

    /**
     * 修改
     */
    UPDATE,

    /**
     * 删除
     */
    DELETE,

    /**
     * 未知
     */
    UNKNOWN;

}
