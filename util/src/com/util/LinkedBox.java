package com.util;

public class LinkedBox implements Box{

    private Node head;
    private int count = 0;

    @Override
    public boolean add(Object object){
        Node n = new Node(object, null, null);
        if (head == null) {
            head = n;
            count ++;
            return true;
        }
        // 寻找目前的末尾节点，将新节点添加到末尾
        Node currentNode = head;
        while (true) {
            if (currentNode.right == null) {
                currentNode.right = n;
                count++;
                return true;
            }
            currentNode = currentNode.right;
        }
    }
    @Override
    public int size(){
        return count;
    }
    @Override
    public Object get(int i){
        int index = 0;
        Node currentNode = head;
        while (true) {
            if (index == i) {
                break;
            }
            index++;
            currentNode = currentNode.right;
        }
        return currentNode.obj;
    }
    @Override
    public Object remove(int i){
        int index = 0;
        Node currentNode = head;
        int prevIndex = i - 1;
        Node prevNode = null;
        while (true) {
            if (index == prevIndex) {
                prevNode = currentNode;
            }
            if (index == i) {
                break;
            }
            index++;
            currentNode = currentNode.right;
        }
        Object obj = currentNode.obj;
        if (i == 0) {
            head = head.right;
        }
        prevNode.right = currentNode.right;
        count --;
        return obj;
    }
    @Override
    public Object[] toArray(){
        Object[] objects = new Object[count];
        Node node = head;
        int index = 0;
        while (true) {
            objects[index] = node.obj;
            if (node.right == null) {
                break;
            }
            index++;
            node = node.right;
        }
        return objects;
    }
}

class Node{
    Object obj;
    Node right;
    Node left;

    public Node(){}

    public Node(Object obj, Node left, Node right) {
        this.obj = obj;
        this.left = left;
        this.right = right;
    }
}
