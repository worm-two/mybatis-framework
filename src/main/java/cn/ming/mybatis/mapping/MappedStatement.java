package cn.ming.mybatis.mapping;

import cn.ming.mybatis.session.Configuration;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @Author: xuming
 * @Date: 2023-07-11 7:41
 * @Version: 1.0
 * @Description: 映射语句类
 **/
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MappedStatement {

    private Configuration configuration;
    private String id;
    private SqlCommandType sqlCommandType;
    private String parameterType;
    private String resultType;
    private String sql;
    private Map<Integer, String> parameter;

}
