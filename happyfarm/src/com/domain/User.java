package com.domain;

import com.util.ArrayBox;
import com.util.Box;

/**
 * @author aidenli
 *
 * 账户
 * */
public class User {
    private String uname;
    private String upass;

    private Box seeds = new ArrayBox();
    private Box fruits = new ArrayBox();
    private Farm farm = new Farm();

    public User(){}
    public User(String uname, String upass){
        this.uname = uname;
        this.upass = upass;
    }


    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpass() {
        return upass;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }

    public Box getSeeds() {
        return seeds;
    }

    public void setSeeds(Box seeds) {
        this.seeds = seeds;
    }

    public Box getFruits() {
        return fruits;
    }

    public void setFruits(Box fruits) {
        this.fruits = fruits;
    }

    public Farm getFarm() {
        return farm;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }

}

