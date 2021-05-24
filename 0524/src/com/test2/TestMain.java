package com.test2;

import java.util.Scanner;

/**
 * 双色球
 * 红色6球 【1-33】
 * 蓝色1球 【1-16】
 * 不允许重复
 * 没有顺序
 * 幸运号码 inputMyNum()
 * 随机产生中奖号码
 * 幸运号码 / 中奖号码比较
 * @author aidenli
 */
public class TestMain {
    public static void main(String[] args) {
        int[] myNums = inputMyNum();
    }
    public static int[] generator(){
        int[] nums = new int[7];
        int count = 0;
        return nums;
    }
    public static int[] inputMyNum() {
        int[] nums = new int[7];
        int count = 0;
        int i = 0;
        Scanner input = new Scanner(System.in);
        System.out.print("请输入红球号码[1-33]： ");
        a: while (count < 6) {
            int num = input.nextInt();
            if (num < 1 || num > 33) {
                System.out.print("请输入1-33中的号码： ");
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (nums[j] == num) {
                    System.out.println("输入重复，请重新输入：");
                    continue a;
                }
            }
            nums[i] = num;
            i++;
            count++;
        }
        System.out.println("请输入蓝球[1-16]： ");
        while (true) {
            int num = input.nextInt();
            if (num < 1 || num > 16) {
                System.out.println("请输入1-16中的号码： ");
                continue;
            }
            nums[nums.length - 1] = num;
            break;
        }
        return nums;
    }
}
