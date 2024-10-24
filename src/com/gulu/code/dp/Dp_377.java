package com.gulu.code.dp;

/**
 * 组合总和 Ⅳ
 *  完全背包
 *  构成背包的不同排列组合数，求排列外层遍历背包，内层遍历物品
 *
 * @author Gollum
 * @date 2024-10-24 23:48
 */
public class Dp_377 {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int target = 4;
        System.out.println(combinationSum4(nums, target));
    }


    public static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    dp[i] += dp[i -nums[j]];  // dp下标依次减物品得到的排列数之和
                }
            }
        }
        return dp[target];
    }
}
