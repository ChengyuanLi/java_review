package com.test1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestMain {
    public static void main(String[] args) {
        Set set = new HashSet();

        set.add("hello");
        set.add(",");
        set.add("world");

        System.out.println(set.size());

        Iterator iterator = set.iterator();
        String s = (String) iterator.next();
        System.out.println(s);
    }
}
