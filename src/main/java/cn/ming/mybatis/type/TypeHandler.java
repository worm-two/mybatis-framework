package cn.ming.mybatis.type;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author: xuming
 * @Date: 2023-07-24 7:30
 * @Version: 1.0
 * @Description: 类型处理器
 **/
public interface TypeHandler<T> {

    /**
     * 设置参数
     */
    void setParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType) throws SQLException;

}