package com.test;
import com.util.*;
public class Main {

    public static void main(String[] args) {
	// write your code here
        Box box = new LinkedBox();
        box.add("lcy1");
        box.add("lcy2");
        box.add("lcy3");
        System.out.println(box.size());
    }
}
