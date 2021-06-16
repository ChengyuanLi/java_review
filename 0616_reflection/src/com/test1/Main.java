package com.test1;

import javax.xml.transform.Source;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner input = new Scanner(System.in);
        System.out.print("enter the class name:");
        String className = input.nextLine();
        try {
            //类加载，获得类的静态成员
            Class c = Class.forName(className);
            printClassInfo(c);
            System.out.println("====================================================");
            printField(c);
            printConstructor(c);
            printMethod(c);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



    }

    public static void printClassInfo(Class c) {
        System.out.println("类长名：" + c.getName());
        System.out.println("类短名：" + c.getSimpleName());
        System.out.println("父类：" + c.getSuperclass());
        System.out.println("修饰符  ：" + Modifier.toString(c.getModifiers()));
        System.out.println("接口：" + Arrays.toString(c.getInterfaces()));
    }

    public static void printConstructor(Class c) {
        Constructor[] constructors = c.getConstructors();
        System.out.println("公有构造器数量：" + constructors.length);
        System.out.println("声明构造器数量：" + c.getDeclaredConstructors().length);
        int count = 0;
        for (Constructor constructor : constructors) {
            count ++;
            System.out.println("--------------------构造器--------------------");
            System.out.println("第"+ count + "个构造器" + "名称：" + constructor.getName());
            System.out.println("修饰符：" + Modifier.toString(c.getModifiers()));
            System.out.println("参数列表：" + Arrays.toString(constructor.getParameterTypes()));
            System.out.println("--------------------xxxxx--------------------");
        }
    }

    public static void printField(Class c) {
        Field[] fields = c.getFields();
        Field[] dFields = c.getDeclaredFields();

        System.out.println("公共属性数量（包括父类属性）：" + fields.length);
        System.out.println("详细公共属性名称信息：" + Arrays.toString(fields));
        System.out.println("当前类所有属性数量：" + dFields.length);
        System.out.println("当前类属性信息：" + Arrays.toString(dFields));

        for (Field field : fields) {
            System.out.println("--------------------公共属性--------------------");
            System.out.println("属性名：" + field.getName());
            System.out.println("属性修饰符：" + Modifier.toString(field.getModifiers()));
            System.out.println("属性类型：" + field.getType());
        }

        for (Field dField : dFields) {
            System.out.println("--------------------本类属性--------------------");
            System.out.println("属性名：" + dField.getName());
            System.out.println("属性修饰符：" + Modifier.toString(dField.getModifiers()));
            System.out.println("属性类型：" + dField.getType());
        }
    }

    public static void printMethod(Class c) {
        Method[] methods = c.getDeclaredMethods();
        System.out.println("方法数量：" + methods.length);
        int count = 0;
        for (Method method : methods) {
            count ++;
            System.out.println("--------------------本类方法--------------------");
            System.out.println("第"+ count + "个方法，" + "方法名：" + method.getName());
            System.out.println("返回类型：" + method.getReturnType().getSimpleName());
            System.out.println("方法修饰符：" + Modifier.toString(method.getModifiers()));
            System.out.println("属性类型：" + Arrays.toString(method.getParameterTypes()));
        }
    }

}
