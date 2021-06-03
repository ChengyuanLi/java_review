package com.test1;

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
            while (true) {
                synchronized (left) {
                    if (!left.isFlag()) {
                        left.up();
                        break;
                    } else {
                        try {
                            left.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

            while (true) {
                synchronized (right) {
                    if (!right.isFlag()) {
                        right.up();
                        break;
                    } else {
                        try {
                            right.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

            System.out.println(name + " 咔咔一顿吃");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            left.down();
            right.down();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void run() {
        this.eat();
    }
}
