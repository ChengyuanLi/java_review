package com.com;

import java.io.*;

public class test3 {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/aidenli/Desktop/zzz.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

        while (true) {
            int b = bufferedInputStream.read();
            if (b == -1) {
                break;
            }
            System.out.println((char) b);
        }
        bufferedInputStream.close();
        fileInputStream.close();
    }
}
