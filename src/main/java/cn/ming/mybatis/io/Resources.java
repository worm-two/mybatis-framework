package cn.ming.mybatis.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * @Author: xuming
 * @Date: 2023-07-08 16:33
 * @Version: 1.0
 * @Description: TODO
 **/
public class Resources {

    public static Reader getResourcesAsReader(String resource) throws IOException {
        return new InputStreamReader(getResourceAsStream(resource));
    }


    public static InputStream getResourceAsStream(String resource) throws IOException {
        ClassLoader[] classLoaders = getClassLoaders();
        for (ClassLoader classLoader : classLoaders) {
            InputStream inputStream = classLoader.getResourceAsStream(resource);
            if (inputStream != null) {
                return inputStream;
            }
        }
        throw new IOException("Could not find resource " + resource);
    }

    private static ClassLoader[] getClassLoaders() {
        return new ClassLoader[]{ClassLoader.getSystemClassLoader(), Thread.currentThread().getContextClassLoader()};
    }
}