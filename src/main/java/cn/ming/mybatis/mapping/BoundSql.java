package cn.ming.mybatis.mapping;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

/**
 * @Author: xuming
 * @Date: 2023-07-15 13:38
 * @Version: 1.0
 * @Description: 绑定的SQL, 是从SqlSource而来，将动态内容都处理完成得到的SQL语句字符串，其中包括?,还有绑定的参数
 **/
@AllArgsConstructor
@Getter
public class BoundSql {

    private String sql;

    private Map<Integer, String> parametersMappings;

    private String parameterType;

    private String resultType;

}
