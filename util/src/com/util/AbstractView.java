package com.util;

public abstract class AbstractView implements View{
    @Override
    public void show(){

    }
    //传值
    @Override
    public abstract void setData(Object object);
}
