package cn.ming.mybatis.executor.result;

import cn.ming.mybatis.session.ResultContext;

/**
 * @Author: xuming
 * @Date: 2023-07-24 21:12
 * @Version: 1.0
 * @Description: 默认结果上下文
 **/
public class DefaultResultContext implements ResultContext {

    private Object resultObject;
    private int resultCount;

    public DefaultResultContext() {
        this.resultObject = null;
        this.resultCount = 0;
    }

    @Override
    public Object getResultObject() {
        return resultObject;
    }

    @Override
    public int getResultCount() {
        return resultCount;
    }

    public void nextResultObject(Object resultObject) {
        resultCount++;
        this.resultObject = resultObject;
    }

}