package com.util;
public class LinkedBox implements Box{

    private Node head;
    private int count = 0;

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
    public int size(){
        return count;
    }
    public Object get(int i){
        return null;
    }
    public Object remove(int i){
        return null;
    }
    public Object[] toArray(){
        return null;
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