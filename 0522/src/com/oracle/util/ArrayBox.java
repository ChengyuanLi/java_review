package com.oracle.util;

/**
 * @author aidenli
 */
public class ArrayBox implements Box{

    private Object[] elements;
    private int count = 0;

    public ArrayBox(){
        this(16);
    }

    public ArrayBox(int length) {
        this.elements = new Object[length];
    }


    @Override
    public void add(Object object) {
        checkLength(1);
        this.elements[count] = object;
        count++;
    }

    private void checkLength(int needLength){
        int minNeed = this.count + needLength;
        if (minNeed > this.elements.length) {
            // need more space
            int minLength = this.elements.length << 1 + 1;
            minLength = Math.max(minLength, minNeed);
            Object[] newElements = new Object[minLength];
            copyArray(newElements, 0, elements, 0, this.elements.length);
            this.elements = newElements;
        }
    }

    private void copyArray(Object[] target, int targetStart, Object[] source, int sourceStart, int copyLength){
        for (int i = 0; i < copyLength; i++) {
            target[targetStart + i] = source[sourceStart + i];
        }
    }

    @Override
    public int size()  {
        return count;
    }

    @Override
    public Object get(int i) {
        checkIndex(i);
        return elements[i];
    }

    /**
     * check legal position
     * @param i
     * @throws BoxIndexOutOfBoundException
     */
    private void checkIndex(int i) {
        if (i < 0 || i >= count) {
            throw new BoxIndexOutOfBoundException();
        }
    }

    /**
     * for method add
     * @param i
     */
    private void checkIndex2(int i) {
        if (i < 0 || i > count) {
            throw new BoxIndexOutOfBoundException();
        }
    }

    /**
     * 需要验证！
     * @param i position
     * @return
     */
    @Override
    public Object remove(int i) {
        checkIndex(i);
        Object result = this.elements[i];
        copyArray(elements, i, elements, i + 1, elements.length - i);
        elements[count - 1] = null;
        count --;
        return result;
    }

    @Override
    public void add(int i, Object object) {
        checkIndex2(i);
        for (int j = count - 1; j >= i; j--) {
            elements[j + 1] = elements[j];
        }
        elements[i] = object;
        count ++;
    }

    @Override
    public Object[] toArray() {
        Object[] newElements = new Object[count];
        for (int i = 0; i < count; i++) {
            newElements[i] = elements[i];
        }
        return newElements;
    }
}
