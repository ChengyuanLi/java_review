package com.test;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        File file = new File("/Users/aidenli/Desktop/zzz.txt");
        FileReader fileReader = new FileReader(file);

        while (true) {
            int c = fileReader.read(); // -128 - 127
            if (c == -1) {
                break;
            }
            System.out.println((char)c);
        }

        fileReader.close();


    }
}
