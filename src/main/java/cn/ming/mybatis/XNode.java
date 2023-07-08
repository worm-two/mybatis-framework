package cn.ming.mybatis;

import lombok.Data;

import java.util.Map;

/**
 * @Author: xuming
 * @Date: 2023-07-08 13:18
 * @Version: 1.0
 * @Description: 解析Mapper节点
 **/
@Data
public class XNode {

    private String namespace;

    private String id;

    private String parameterType;

    private String resultType;

    private String sql;

    private Map<Integer, String> parameter;
}
