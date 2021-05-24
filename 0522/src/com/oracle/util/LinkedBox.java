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

    }

    /**
     * get the size of the container
     *
     * @return size
     */
    @Override
    public int size() {
        return count;
    }

    /**
     * get object in position i
     *
     * @param i position
     * @return object
     * @throws , when position off bound 非受检异常
     */
    @Override
    public Object get(int i) {
        checkIndex(i);
        Node node = getNode(i);
        return node.element;
    }

    private Node getNode(int i){
        if (i < count >> 1){
            //first half
            int index = 0;
            Node node = head;
            while (index < i) {
                node = node.next;
                index++;
            }
        }
            //last half
            int index = count - 1;
            Node node = tail;
            while (index > i) {
                node = node.prev;
                index --;
            }
        return node;
    }

    private void checkIndex(int i) {
        if(i < 0 || i >= count) {
            throw new BoxIndexOutOfBoundException();
        }
    }
    private void checkIndex2(int i) {
        if(i < 0 || i > count) {
            throw new BoxIndexOutOfBoundException();
        }
    }

    /**
     * delete position object and return that object
     *
     * @param i position
     * @return deleted object
     */
    @Override
    public Object remove(int i) {
        Node node = getNode(i);
        if (count == 1) {
            head = null;
            tail = null;
            count --;
            return node.element;
        }
        if (node == head) {
            head.next.prev = null;
            head = head.next;
            count --;
            return node.element;
        }
        if (node == tail) {
            tail.prev.next = null;
            tail = tail.prev;
            count --;
            return node.element;
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
        count --;
        return node.element;
    }

    /**
     * add position to i position
     *
     * @param i      position
     * @param object add object
     * @throws , when position off bound 非受检异常
     */
    @Override
    public void add(int i, Object object) {
        checkIndex2(i);
        if (i == count){
            this.add(object);
            return;
        }
        Node node = getNode(i);
        Node newNode = new Node(object, null, null);
        if (node == head) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            count++;
            return;
        }
        newNode.next = node;
        newNode.prev = node.prev;
        node.prev.next = newNode;
        node.prev = newNode;
        count++;
    }

    /**
     * put object in container to an array and return
     *
     * @return return an array
     */
    @Override
    public Object[] toArray() {
        Object[] elements = new Object[count];
        Node node = head;
        int i = 0;
        while (node != null) {
            elements[i] = node.element;
            i++;
            node = node.next;
        }
        return elements;
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
