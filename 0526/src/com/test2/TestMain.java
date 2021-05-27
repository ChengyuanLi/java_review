package com.test2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author aidenli
 */
public class TestMain {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/aidenli/Desktop/zzz2.txt");
        FileWriter fileWriter = new FileWriter(file);
        String s = "天安门广场";
        fileWriter.write(s);
        fileWriter.close();

    }
}
