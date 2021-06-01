package com.util;

/**
 * 使用策略模式的对应接口
 * 输出对象时的序列化策略规范
 */
public interface OutStrategy<T> {
    //将对象变成字符串
    public String cast(T object);
}
