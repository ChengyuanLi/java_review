package com.oracle.util;

/**
 * @author aidenli
 */
public class LinkedBox implements Box{

    private Node head = null;
    private Node tail = null;
    private int count = 0;

    /**
     * add object to container
     *
     * @param object add object
     */
    @Override
    public void add(Object object) {
        Node node = new Node(object, null, null);
        if (head == null) {
            head = node;
            tail = node;
            count ++;
            return;
        }

        tail.next = node;
        node.prev = tail;
        tail = node;
        count ++;
        return;

    }

    /**
     * get the size of the container
     *
     * @return size
     */
    @Override
    public int size() {
        return 0;
    }

    /**
     * get object in position i
     *
     * @param i position
     * @return object
     * @throws xxxException, when position off bound 非受检异常
     */
    @Override
    public Object get(int i) {
        return null;
    }

    /**
     * delete position object and return that object
     *
     * @param i position
     * @return deleted object
     */
    @Override
    public Object remove(int i) {
        return null;
    }

    /**
     * add position to i position
     *
     * @param i      position
     * @param object add object
     * @throws xxxException, when position off bound 非受检异常
     */
    @Override
    public void add(int i, Object object) {

    }

    /**
     * put object in container to an array and return
     *
     * @return return an array
     */
    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    class Node{
        Object element;
        Node next;
        Node prev;

        Node(){}
        Node(Object element, Node next, Node prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }




}
