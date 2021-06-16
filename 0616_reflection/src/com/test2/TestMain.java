package com.test2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestMain {
    public static void main(String[] args) {
        String className = "com.test2.A";
        Class clazz = null;
        try {
            clazz = Class.forName(className);
            Constructor constructor = clazz.getConstructor(int.class);
            Object obj = constructor.newInstance(100);
            Field f = clazz.getDeclaredField("i");
            f.setAccessible(true);
            f.set(obj, 60); // set value
            Object o = f.get(obj); // get value
            f.setAccessible(false);
            System.out.println(o);
            System.out.println(obj);


            Method m = clazz.getDeclaredMethod("t1");
            m.invoke(obj);

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

    class  A {

        public A() {
        }

        public A(int i) {
            this.i = i;
        }

        private int i = 10;

        public void t1() {
            System.out.println("t1()方法 + " + i);
        }

        @Override
        public String toString() {
            return "我是A" + i;
        }
    }
