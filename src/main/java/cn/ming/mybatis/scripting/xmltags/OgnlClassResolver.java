package cn.ming.mybatis.scripting.xmltags;

import cn.ming.mybatis.io.Resources;
import ognl.ClassResolver;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xuming
 * @Date: 2023-07-26 7:42
 * @Version: 1.0
 * @Description: TODO
 **/
public class OgnlClassResolver implements ClassResolver {

    private Map<String, Class<?>> classes = new HashMap<String, Class<?>>(101);

    @Override
    public Class classForName(String className, Map context) throws ClassNotFoundException {
        Class<?> result = null;
        if ((result = classes.get(className)) == null) {
            try {
                result = Resources.classForName(className);
            } catch (ClassNotFoundException e1) {
                if (className.indexOf('.') == -1) {
                    result = Resources.classForName("java.lang." + className);
                    classes.put("java.lang." + className, result);
                }
            }
            classes.put(className, result);
        }
        return result;
    }

}
