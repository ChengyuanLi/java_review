package com.util;

import java.io.*;

/**
 * io操作的基本类
 * @author aidenli
 */
public class BaseIO {


    protected String read(String file) {
        return this.read(new File(file));
    }

    protected <T> T read(String file, InStrategy<T> inStrategy) {
        String content = this.read(file);
        return inStrategy.cast(content);
    }

    protected String read(File file) {
        StringBuilder content = new StringBuilder();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                content.append(line);

            }
            return content.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    protected final void write(String file,String content) {
        this.write(new File(file), content, false);
    }

    protected final void write(File file, String content) {
        this.write(file, content, false);
    }

    protected final void write(String file, String content, boolean append) {
        this.write(new File(file), content, append);
    }

    protected final <T> void write(String file, T obj, OutStrategy<T> outStrategy,  boolean append) {
        //将obj中的内容取出，组成一个字符串，序列化
        //策略模式，在使用方法的同时给方法说明使用的策略。
        String content = outStrategy.cast(obj);
        this.write(new File(file), content, append);
    }

    protected final <T> void write(String file, T obj, OutStrategy<T> outStrategy) {
        this.write(file, obj, outStrategy, false);
    }

    protected final void write(File file, String content, boolean append) {
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
