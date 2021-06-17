package com.server;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 根据请求调用对应类对象的相应方法
 * 映射关系要求开发者定义在工程根目录中的mapping.properties中
 * @author aidenli
 */

public class Controller {

    static Properties p = new Properties();

    static {
        InputStream is = null;
        try {
            is = new FileInputStream("mapping.properties");
            p.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mapping(Request request, Response response) {
        String className = p.getProperty(request.getContent());
        if (className == null) {
            return;
        }

        try {
            Class c = Class.forName(className);
            Object obj = c.newInstance();
            Action action = (Action) obj;
            action.control(request, response);
            /* todo */
        } catch (ClassNotFoundException |
                InstantiationException |
                IllegalAccessException e) {
            e.printStackTrace();
        }

    }

}
