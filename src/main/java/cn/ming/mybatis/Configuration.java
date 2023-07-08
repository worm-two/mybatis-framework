package cn.ming.mybatis;

import lombok.Setter;

import java.sql.Connection;
import java.util.Map;

/**
 * @Author: xuming
 * @Date: 2023-07-08 16:29
 * @Version: 1.0
 * @Description: Mybatis配置数据持有类
 **/
@Setter
public class Configuration {

    protected Connection connection;

    protected Map<String, String> database;

    protected Map<String, XNode> mapperElement;
}
