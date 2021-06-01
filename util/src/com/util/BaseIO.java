package com.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * io操作的基本类
 * @author aidenli
 */
public class BaseIO {


    protected void read() {}

    protected void write(String file,String content) {
        this.write(new File(file), content, false);
    }

    protected void write(File file, String content) {
        this.write(file, content, false);
    }

    protected void write(String file, String content, boolean append) {
        this.write(new File(file), content, append);
    }

    protected <T> void write(String file, T obj, OutStrategy<T> outStrategy,  boolean append) {
        //将obj中的内容取出，组成一个字符串，序列化
        //策略模式，在使用方法的同时给方法说明使用的策略。
        String content = outStrategy.cast(obj);
        this.write(new File(file), content, append);
    }

    protected void write(File file, String content, boolean append) {
        FileOutputStream fileOutputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file, append);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            bufferedOutputStream.write(content.getBytes());
            bufferedOutputStream.close();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
