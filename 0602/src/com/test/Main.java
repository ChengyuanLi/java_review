package com.test;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Window window1 = new Window();
        window1.setName("YYZ");
        Window window2 = new Window();
        window2.setName("PEK");
        Window window3 = new Window();
        window3.setName("SHA");
        Window window4 = new Window();
        window4.setName("HKG");
        Window window5 = new Window();
        window5.setName("LAX");

        Thread t1 = new Thread(window1);
        Thread t2 = new Thread(window2);
        Thread t3 = new Thread(window3);
        Thread t4 = new Thread(window4);
        Thread t5 = new Thread(window5);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
