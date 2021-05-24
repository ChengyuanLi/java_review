package com.oracle.test;

import com.oracle.util.ArrayBox;
import com.oracle.util.LinkedBox;

/**
 * @author aidenli
 */
public class TestMain {
    public static void main(String[] args) {
        ArrayBox arrayBox = new ArrayBox();
        LinkedBox linkedBox = new LinkedBox();
        for (int i = 0; i < 1000; i ++) {
            arrayBox.add("LCY array" + i);
            linkedBox.add("LCY linked"+ i);
        }


        System.out.println(arrayBox.get(288));
        System.out.println(arrayBox.size());
        System.out.println(linkedBox.get(1));
        System.out.println(linkedBox.get(738));
        System.out.println(linkedBox.size());

        linkedBox.remove(738);
        System.out.println(linkedBox.get(738));
        System.out.println(linkedBox.size());



        arrayBox.remove(288);




    }
}
