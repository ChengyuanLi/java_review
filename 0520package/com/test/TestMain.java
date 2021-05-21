package com.test;
import  com.util.*;
public class TestMain {
	public static void main(String[] args) {
		Box box = new LinkedBox();
		box.add("lcy1");
		box.add("lcy2");
		box.add("lcy3");
		System.out.println(box.size());
	}
	
}