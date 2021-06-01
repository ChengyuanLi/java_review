package com.util;

/**
 * @author aidenli
 * @see java.util.ArrayList
 */
@Deprecated
public class ArrayBox implements Box{
    //以数组形式实现存储
    private int count = 0;
    private Object[] elements;

    public ArrayBox() {
        this(0x10);
    }
    public ArrayBox(int length) {
        this.elements = new Object[length];
    }

    @Override
    public boolean add(Object object) {
        checkLength(1);
        this.elements[count] = object;
        count++;
        return true;
    }

    private void checkLength(int length) {
        int needMinLength = count + length;
        if (needMinLength > this.elements.length) {
            int newLength = this.elements.length << 1 + 1;
            newLength = newLength > needMinLength ? newLength : needMinLength;
            Object[] newElements = new Object[newLength];
            copy(this.elements, 0, newElements, 0, count);
            this.elements = newElements;
        }
    }

    private void copy(Object[] source, int start, Object[] target, int begin, int length) {
        int sIndex = start;
        int tIndex = begin;
        int count = 0;
        while (true) {
            if (count++ == length) {
                break;
            }
            if (sIndex == source.length) {
                break;
            }
            if (tIndex == target.length) {
                break;
            }
            target[tIndex ++] = source[sIndex ++];
        }
    }

    @Override
    public Object get(int i) {
        return this.elements[i];
    }

    @Override
    public int size(){
        return count;
    }

    @Override
    public Object remove(int i) {
        Object removeObject = this.elements[i];
        copy(this.elements, i + 1, this.elements, i, count - i - 1);
        this.elements[count - 1] = null;
        count --;
        return removeObject;
    }

    @Override
    public Object[] toArray() {
        Object[] newElements = new Object[count];
        copy(this.elements, 0, newElements, 0, count);
        return newElements;
    }

}
