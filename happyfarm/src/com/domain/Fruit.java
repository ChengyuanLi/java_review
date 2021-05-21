package com.domain;

/**
 * @author aidenli
 */
public class Fruit {
    private String fname;
    private int count;

    public Fruit() {
    }

    public Fruit(String fname, int count) {
        this.fname = fname;
        this.count = count;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
