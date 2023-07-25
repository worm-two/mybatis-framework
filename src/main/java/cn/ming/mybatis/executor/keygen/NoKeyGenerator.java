package cn.ming.mybatis.executor.keygen;

import cn.ming.mybatis.executor.Executor;
import cn.ming.mybatis.mapping.MappedStatement;

import java.sql.Statement;

/**
 * @Author: xuming
 * @Date: 2023-07-25 21:36
 * @Version: 1.0
 * @Description: 不用键值生成器
 **/
public class NoKeyGenerator implements KeyGenerator {

    @Override
    public void processBefore(Executor executor, MappedStatement ms, Statement stmt, Object parameter) {
        // Do Nothing
    }

    @Override
    public void processAfter(Executor executor, MappedStatement ms, Statement stmt, Object parameter) {
        // Do Nothing
    }

}
