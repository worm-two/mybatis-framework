package cn.ming.mybatis.type;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author: xuming
 * @Date: 2023-07-24 20:38
 * @Version: 1.0
 * @Description: String类型处理器
 **/
public class StringTypeHandler extends BaseTypeHandler<String> {

    @Override
    protected void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter);
    }

}
