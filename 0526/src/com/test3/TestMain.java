package com.test3;

import java.io.*;

public class TestMain {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/aidenli/Desktop/zzz.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

        String s = "CHINA IS GOOD!";

            bufferedOutputStream.write(s.getBytes());
            bufferedOutputStream.flush();
        

        fileOutputStream.flush();

    }
}
