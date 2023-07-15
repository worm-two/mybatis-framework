package cn.ming.mybatis.datasource;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @Author: xuming
 * @Date: 2023-07-15 13:37
 * @Version: 1.0
 * @Description: 数据源工厂
 **/
public interface DataSourceFactory {

    String DRIVER = "driver";

    String URL = "url";

    String USERNAME = "username";

    String PASSWORD = "password";

    void setProperties(Properties props);

    DataSource getDataSource();
}
