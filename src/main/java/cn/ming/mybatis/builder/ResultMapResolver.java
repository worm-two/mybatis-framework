package cn.ming.mybatis.builder;

import cn.ming.mybatis.mapping.ResultMap;
import cn.ming.mybatis.mapping.ResultMapping;

import java.util.List;

/**
 * @Author: xuming
 * @Date: 2023-07-25 21:10
 * @Version: 1.0
 * @Description: 结果映射解析器
 **/
public class ResultMapResolver {

    private final MapperBuilderAssistant assistant;
    private String id;
    private Class<?> type;
    private List<ResultMapping> resultMappings;

    public ResultMapResolver(MapperBuilderAssistant assistant, String id, Class<?> type, List<ResultMapping> resultMappings) {
        this.assistant = assistant;
        this.id = id;
        this.type = type;
        this.resultMappings = resultMappings;
    }

    public ResultMap resolve() {
        return assistant.addResultMap(this.id, this.type, this.resultMappings);
    }

}
