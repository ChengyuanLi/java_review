package com.util;

public interface Box {
    public boolean add(Object object);
    public int size();
    public Object get(int i);
    public Object remove(int i);
    public Object[] toArray();
}
