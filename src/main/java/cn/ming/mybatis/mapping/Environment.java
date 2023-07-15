package cn.ming.mybatis.mapping;

import cn.ming.mybatis.transaction.TransactionFactory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.sql.DataSource;

/**
 * @Author: xuming
 * @Date: 2023-07-15 13:38
 * @Version: 1.0
 * @Description: 环境
 **/
@AllArgsConstructor
@Builder
@Getter
public class Environment {

    private String id;

    private final TransactionFactory transactionFactory;

    private final DataSource dataSource;
}
