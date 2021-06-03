package com.test;

import sun.util.resources.cldr.cy.LocaleNames_cy;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Fork fork1 = new Fork();
        Fork fork2 = new Fork();
        Fork fork3 = new Fork();
        Fork fork4 = new Fork();
        Fork fork5 = new Fork();
        Fork fork6 = new Fork();

        People people1 = new People(fork1, fork2, "lcy");
        People people2 = new People(fork2, fork3, "mtf");
        People people3 = new People(fork3, fork4, "tzr");
        People people4 = new People(fork4, fork5, "dsb");
        People people5 = new People(fork5, fork6, "xsb");
        People people6 = new People(fork6, fork1, "yyds");

        Thread t1 = new Thread(people1);
        Thread t2 = new Thread(people2);
        Thread t3 = new Thread(people3);
        Thread t4 = new Thread(people4);
        Thread t5 = new Thread(people5);
        Thread t6 = new Thread(people6);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();


    }
}
