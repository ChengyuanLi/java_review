package com.bubbleSort;

public class TestMain {
    public static void main(String[] args) {
        int[] nums = new int[]{7,4,6,5,1,9,2};
        printArray(nums);
        for (int i = 1; i <= nums.length - 1; i++) {
            for (int j = 1; j <= nums.length - i; j ++) {
                if (nums[j  - 1] > nums[j]) {
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        printArray(nums);

    }

    public static void printArray(int[] nums){
        for (int num : nums) {
            System.out.print(num + "\t");
        }
        System.out.println();
    }
}
