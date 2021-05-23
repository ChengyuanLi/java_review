package com.oracle.test;

import com.oracle.util.ArrayBox;

/**
 * @author aidenli
 */
public class TestMain {
    public static void main(String[] args) {
        ArrayBox arrayBox = new ArrayBox();
        for (int i = 0; i < 1000; i ++) {
            arrayBox.add("LCY" + i);
        }


        System.out.println(arrayBox.get(288));

    }
}
