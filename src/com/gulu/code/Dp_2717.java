package com.gulu.code;

/**
 * 半有序排列
 *
 * @author chocolate
 * 2024/12/11 15:06
 */
public class Dp_2717 {

    public static void main(String[] args) {
        int[] nums = {2, 1, 4, 3};
        System.out.println(semiOrderedPermutation(nums));
    }

    public static int semiOrderedPermutation(int[] nums) {
        int minIndex = 0, maxIndex = 0, min = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= max) {
                max = nums[i];
                maxIndex = i;
            }
            if (nums[i] < min) {
                min = nums[i];
                minIndex = i;
            }
        }
        return minIndex + nums.length - maxIndex - (minIndex > maxIndex ? 2 : 1);
    }

}
