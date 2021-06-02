package com.test3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 多线程读取大文件
 * @author aidenli
 */
public class Reader extends Thread{
    // 目标文件
    private File file;
    // 储存数组
    private byte[] target;
    // 读取位置
    private int start;
    // 读取长度
    private int length;
    // 读取状态
    private boolean flag = false;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public byte[] getTarget() {
        return target;
    }

    public void setTarget(byte[] target) {
        this.target = target;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Reader(File file, byte[] target, int start, int length) {
        this.file = file;
        this.target = target;
        this.start = start;
        this.length = length;
    }

    public void read() {
        try {

            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.skip(start);
            fileInputStream.read(target, start, length);

            fileInputStream.close();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void run() {
        this.read();
    }
}
