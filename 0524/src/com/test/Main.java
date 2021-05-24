package com.test;

import java.math.BigInteger;
import java.util.logging.Logger;

/**
 * @author aidenli
 */
public class Main {

    private static final BigInteger DEFAULT_NUM = new BigInteger("1");
    public static void main(String[] args) {
	// write your code here
        BigInteger num = new BigInteger("200");
        BigInteger ji = jc(num);
        System.out.println(ji);
    }

    public static BigInteger jc(BigInteger num) {
        if (num.equals(DEFAULT_NUM)) {
            return DEFAULT_NUM;
        }
        return num.multiply(jc(num.subtract(DEFAULT_NUM)));
    }


}
