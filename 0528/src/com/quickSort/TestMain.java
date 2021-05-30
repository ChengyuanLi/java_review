package com.quickSort;

/**
 * @author aidenli
 */
public class TestMain {
    public static void main(String[] args) {
        int[] nums = new int[]{7,4,6,5,1,9,2};
        printArray(nums);
        for (int i = 1; i <= nums.length - 1; i++) {
            int max = nums[0];
            int index = 0;
            for (int j = 1; j <= nums.length - i; j ++) {
                if (max < nums[j]) {
                    max = nums[j];
                    index = j;
                }

            }

            nums[index] = nums[nums.length - i];
            nums[nums.length - i] = max;
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
