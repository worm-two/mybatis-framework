package cn.ming.mybatis.scripting.xmltags;

/**
 * @Author: xuming
 * @Date: 2023-07-24 7:51
 * @Version: 1.0
 * @Description: 静态文本SQL节点
 **/
public class StaticTextSqlNode implements SqlNode {

    private String text;

    public StaticTextSqlNode(String text) {
        this.text = text;
    }

    @Override
    public boolean apply(DynamicContext context) {
        //将文本加入context
        context.appendSql(text);
        return true;
    }

}
