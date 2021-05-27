package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        File source = new File("/Users/aidenli/Desktop/laiyuan");
        File target = new File("/Users/aidenli/Documents");

        copy(source, target);
    }

    public static void copy(File sourceFile, File targetFile) throws IOException {
        String copyDirName = sourceFile.getName();
        File copyDir = new File(targetFile, copyDirName);
        copyDir.mkdir();

        File[] files = sourceFile.listFiles();

        for (int i = 0; i < files.length; i ++) {
            File file = files[i];
            if (file.isDirectory()) {
                copy(file, copyDir);
                continue;
            }
            File target = new File(copyDir, file.getName());
            target.createNewFile();
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(target);
            while (fileInputStream.available() > 0) {
                int b = fileInputStream.read();
                fileOutputStream.write(b);
            }
            fileInputStream.close();
            fileOutputStream.close();
        }
    }
}
