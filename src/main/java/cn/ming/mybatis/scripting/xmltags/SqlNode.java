package cn.ming.mybatis.scripting.xmltags;

/**
 * @Author: xuming
 * @Date: 2023-07-24 7:36
 * @Version: 1.0
 * @Description: SQL 节点
 **/
public interface SqlNode {

    boolean apply(DynamicContext context);

}