package com.test2;

import java.util.Random;
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
        int[] gNums = generator();
        int countR = 0;
        boolean blue = false;

        for (int i = 0; i < myNums.length - 1; i++) {
            int myNum = myNums[i];
            for (int j = 0; j < gNums.length - 1; j++) {
                int gNum = gNums[j];
                if (myNum == gNum) {
                    countR++;
                    break;
                }
            }
        }
        blue = myNums[myNums.length - 1] == gNums[gNums.length - 1];

        sort(myNums);
        sort(gNums);

        for(int i = 0; i < myNums.length; i++) {
            System.out.print(myNums[i] + "\t");
        }
        System.out.println();
        for(int i = 0; i < myNums.length; i++) {
            System.out.print(gNums[i] + "\t");
        }
        System.out.println();

      if (countR == 6 && blue) {
            System.out.println("500w到手！！！！！");
        } else if (countR == 3 && blue) {
            System.out.println("10块到手");
        } else if (countR == 4 || blue) {
            System.out.println("5块到手");
        } else {
            System.out.println("谢谢惠顾");
        }

    }

    public static void sort(int[] nums) {
        for (int i = 1; i < nums.length - 1; i++) {
            for (int j = 1; j <= nums.length - i - 1; j++) {
                if (nums[j - 1] > nums[j]) {
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    public static int[] generator(){
        Random random = new Random();
        int[] nums = new int[7];
        int count = 0;
        a: while (count < 6) {
            int num = random.nextInt(33) + 1;
            for (int j = 0; j < count; j++) {
                if (nums[j] == num) {
                    continue a;
                }
            }
            nums[count] = num;
            count++;
        }
        nums[nums.length - 1] = random.nextInt(16) + 1;
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
