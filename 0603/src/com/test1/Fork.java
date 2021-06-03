package com.test1;

/**
 * @author aidenli
 */
public class Fork {
    //餐具使用状态
    private boolean flag;
    private long time;

    public synchronized void up() {
        this.time = System.currentTimeMillis();
        this.flag = true;
    }

    public synchronized void down() {
        this.time = 0;
        this.flag = false;
        this.notifyAll();
    }

    public synchronized boolean isFlag() {
        return flag;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
