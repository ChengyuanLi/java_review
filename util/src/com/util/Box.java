package com.util;

public interface Box {
    boolean add(Object object);
    //返回装载元素的结果
    Object get(int i);
    //返回指定位置的元素
    int size();
    //返回容器中装载元素的个数
    Object remove(int i);
    //删除指定位置的元素并返回
    Object[] toArray();
    //以数组形式返回容器中的内容
}
