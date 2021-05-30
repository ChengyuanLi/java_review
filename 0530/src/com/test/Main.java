package com.test;

public class Main {

    public static void main(String[] args) {
	// write your code here
        t1();
        t1(10);
        t1(10,20);
        t1(10,20,30,40);
        t1(new int[]{1,2,3,4,5,6,7});
    }

    public static void t1(int... nums) {
        for (int num : nums) {
            System.out.println(nums[num]);
        }
    }


    //效果和方法的重载相同
    public static void t1(){}
    public static void t1(int i){}
    public static void t1(int i, int j){}
}
