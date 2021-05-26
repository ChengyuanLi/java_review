package com.util;

/**
 * 缺省适配器模式
 * @author aidenli
 */
public abstract class AbstractView implements View{
    @Override
    public abstract void show();

    public void setData(Object data) {
        //force to override
        throw new RuntimeException();
    }
}
