package cn.ming.mybatis.mapping;

import cn.ming.mybatis.transaction.TransactionFactory;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.sql.DataSource;

/**
 * @Author: xuming
 * @Date: 2023-07-15 13:38
 * @Version: 1.0
 * @Description: 环境
 **/
@AllArgsConstructor
@Getter
public class Environment {

    private String id;

    private final TransactionFactory transactionFactory;

    private final DataSource dataSource;

    public static class Builder {

        private String id;
        private TransactionFactory transactionFactory;
        private DataSource dataSource;

        public Builder(String id) {
            this.id = id;
        }

        public Builder transactionFactory(TransactionFactory transactionFactory) {
            this.transactionFactory = transactionFactory;
            return this;
        }

        public Builder dataSource(DataSource dataSource) {
            this.dataSource = dataSource;
            return this;
        }

        public String id() {
            return this.id;
        }

        public Environment build() {
            return new Environment(this.id, this.transactionFactory, this.dataSource);
        }

    }

}
