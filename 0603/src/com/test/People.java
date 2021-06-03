package com.test;

/**
 * @author aidenli
 */
public class People implements Runnable{
    private Fork left;
    private Fork right;

    private String name;

    public People() {}

    public People(Fork left, Fork right, String name) {
        this.left = left;
        this.right = right;
        this.name = name;
    }

    public Fork getLeft() {
        return left;
    }

    public void setLeft(Fork left) {
        this.left = left;
    }

    public Fork getRight() {
        return right;
    }

    public void setRight(Fork right) {
        this.right = right;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void eat() {
        while (true) {
            //拿起left
            synchronized (left) {
                //拿起right
                synchronized (right){
                    //this.name = Thread.currentThread().getName();
                    System.out.println(name + " 咔咔一顿吃");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        this.eat();
    }
}
