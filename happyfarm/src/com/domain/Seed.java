package com.domain;

/**
 * @author aidenli
 */
public class Seed {

    private String sname;
    private int flag;
    // 0 芽， 1 苗， 2 果实
    /*
    * null no seed: *****
    * 0    芽     ： |
    * 1    苗     ： Y
    * 2    果     ： O
    * */


    private int count;
//    private int price;


    public Seed() {
    }

    public Seed(String sname) {
        this.sname = sname;
        flag = 0;
    }

    public Seed(String sname, int count) {
        this.sname = sname;
        this.count = count;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
