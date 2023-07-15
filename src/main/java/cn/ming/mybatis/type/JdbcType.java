package cn.ming.mybatis.type;

import lombok.AllArgsConstructor;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xuming
 * @Date: 2023-07-15 13:42
 * @Version: 1.0
 * @Description: JDBC类型枚举
 **/
@AllArgsConstructor
public enum JdbcType {

    INTEGER(Types.INTEGER),

    FLOAT(Types.FLOAT),

    DOUBLE(Types.DOUBLE),

    DECIMAL(Types.DECIMAL),

    VARCHAR(Types.VARCHAR),

    TIMESTAMP(Types.TIMESTAMP);


    public final int TYPE_CODE;

    private static Map<Integer, JdbcType> codeLookup = new HashMap<>();


    static {
        for (JdbcType type : JdbcType.values()) {
            codeLookup.put(type.TYPE_CODE, type);
        }
    }

    public static JdbcType forCode(int code) {
        return codeLookup.get(code);
    }
}
