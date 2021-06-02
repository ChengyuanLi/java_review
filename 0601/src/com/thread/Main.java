package com.thread;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Person p = new Person();
        System.out.println(p.toString());
        p.start();
        System.out.println("------------");

    }
}

class Person extends Thread{
    @Override
    public void run() {
        this.clean();
    }

    public void clean() {
        Person person = new Person();
        System.out.println(person.toString());
        System.out.println("clean");
    }

    public void sleep() {

    }
}
