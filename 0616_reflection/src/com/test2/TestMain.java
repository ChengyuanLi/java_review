package com.test2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class TestMain {
    public static void main(String[] args) {
        String className = "com.test2.A";
        Class clazz = null;
        try {
            clazz = Class.forName(className);
            Constructor constructor = clazz.getConstructor(int.class);
            Object obj = constructor.newInstance(30);
            Field f = clazz.getDeclaredField("i");
            Object o = f.get(obj);
            System.out.println(o);
            System.out.println(obj);
        } catch (ClassNotFoundException |
                NoSuchMethodException |
                InstantiationException |
                IllegalAccessException |
                InvocationTargetException |
                NoSuchFieldException e) {
            e.printStackTrace();
        }

    }
}

    class A {

        public A() {
        }

        public A(int i) {
            this.i = i;
        }

        private int i = 10;

        public void t1() {
            System.out.println(i);
        }

        @Override
        public String toString() {
            return "我是A" + i;
        }
    }
