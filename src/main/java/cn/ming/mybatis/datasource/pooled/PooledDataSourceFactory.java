package cn.ming.mybatis.datasource.pooled;

import cn.ming.mybatis.datasource.unpooled.UnpooledDataSourceFactory;

/**
 * @Author: xuming
 * @Date: 2023-07-15 21:37
 * @Version: 1.0
 * @Description: 有连接池的数据源工厂
 **/
public class PooledDataSourceFactory extends UnpooledDataSourceFactory {

    public PooledDataSourceFactory() {
        this.dataSource = new PooledDataSource();
    }

}
