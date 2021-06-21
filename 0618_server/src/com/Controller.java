package com;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * 请求映射，根据请求创建并调用对象
 * 实现请求映射请使用映射关系
 * mapping.properties
 *
 * login = com.action.LoginAction
 * 调用service方法
 * 要求对应的action类要实现Action接口
 */

public class Controller {

    private static Properties p = new Properties();
    static {
        File file = new File("mapping.properties");
        try {
            FileInputStream fis = new FileInputStream(file);
            p.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void mapping(Request request, Response response) {
        String className = p.getProperty(request.getRequestContent());

        try {

            Class clazz = Class.forName(className);
            Object obj = clazz.newInstance();

            Action action = (Action) obj;
            action.service(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
