package com.oracle.util;

/**
 * @author aidenli
 */
public interface Box {
    /**
     * add object to container
     * @param object add object
     */
    public void add(Object object);

    /**
     * get the size of the container
     * @return size
     */
    public int size();

    /**
     * get object in position i
     * @param i position
     * @return object
     * @throws , when position off bound 非受检异常
     */
    public Object get(int i);

    /**
     * delete position object and return that object
     * @param i position
     * @return deleted object
     */
    public Object remove(int i);

    /**
     * add position to i position
     * @param i position
     * @param object add object
     * @throws , when position off bound 非受检异常
     */
    public void add(int i, Object object);

    /**
     * put object in container to an array and return
     * @return return an array
     */
    public Object[] toArray();
}
