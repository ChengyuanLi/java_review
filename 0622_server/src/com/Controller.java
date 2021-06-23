package com;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class Controller {
    static Properties p = new Properties();
    static {
        try {
            FileInputStream fis = new FileInputStream("mapping.properties");
            p.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void mapping(Request request, Response response) {
        String classPath = p.getProperty(request.getRequestContent());

        if (classPath == null || "".equals(classPath)) {
            response.sendDir(classPath);
            return;
        }

        try {
            Class clazz = Class.forName(classPath);
            Object obj = clazz.newInstance();

            Action action = (Action) obj;
            action.service(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
