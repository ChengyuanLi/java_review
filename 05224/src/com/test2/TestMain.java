package com.test2;

import java.math.BigDecimal;

public class TestMain {
    public static void main(String[] args) {
        double d = 3.1415926;
        BigDecimal bd = new BigDecimal(d);
        bd = bd.setScale(3, BigDecimal.ROUND_HALF_DOWN);
        System.out.println(bd);
    }
}
