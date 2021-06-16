package com.test3;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestMain {
    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("com.test3.A");
            Object obj = c.newInstance();
            Field field = c.getDeclaredField("i");
            field.setAccessible(true);
            field.set(obj, 30);
            field.setAccessible(false);
            Method m = c.getDeclaredMethod("print");
            m.invoke(obj);
        } catch (ClassNotFoundException |
                InstantiationException |
                IllegalAccessException |
                NoSuchFieldException |
                NoSuchMethodException |
                InvocationTargetException e) {
            e.printStackTrace();
        }


    }
}

class A {
    private int i;
    public void print() {
        System.out.println(i);
    }
}
