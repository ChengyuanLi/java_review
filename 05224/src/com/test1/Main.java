package com.test1;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
	// write your code here
        BigInteger bigInteger = new BigInteger("200");
        System.out.println(jc(bigInteger));
    }

    public static BigInteger jc(BigInteger num) {
        if (num.equals(new BigInteger("1"))) {
            return new BigInteger("1");
        } else {
            return num.multiply(jc(num.subtract(new BigInteger("1"))));
        }
    }
}
