package com.runnable;

public class TestMain {
    public static void main(String[] args) {
        A a = new A();
        Thread thread = new Thread(a);
        thread.start();
    }
}

class A implements Runnable{

    @Override
    public void run() {
        System.out.println("runnnnnnnnn");
    }
}
