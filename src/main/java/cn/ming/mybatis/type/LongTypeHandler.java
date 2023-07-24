package cn.ming.mybatis.type;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author: xuming
 * @Date: 2023-07-24 20:38
 * @Version: 1.0
 * @Description: Long类型处理器
 **/
public class LongTypeHandler extends BaseTypeHandler<Long> {

    @Override
    protected void setNonNullParameter(PreparedStatement ps, int i, Long parameter, JdbcType jdbcType) throws SQLException {
        ps.setLong(i, parameter);
    }

}