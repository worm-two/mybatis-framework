package cn.ming.mybatis.datasource.druid;

import cn.ming.mybatis.datasource.DataSourceFactory;
import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @Author: xuming
 * @Date: 2023-07-15 13:36
 * @Version: 1.0
 * @Description: Druid数据源工厂
 **/
public class DruidDataSourceFactory implements DataSourceFactory {

    private Properties props;

    @Override
    public void setProperties(Properties props) {
        this.props = props;
    }

    @Override
    public DataSource getDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(props.getProperty(DRIVER));
        druidDataSource.setUrl(props.getProperty(URL));
        druidDataSource.setUsername(props.getProperty(USERNAME));
        druidDataSource.setPassword(props.getProperty(PASSWORD));
        return druidDataSource;
    }
}
