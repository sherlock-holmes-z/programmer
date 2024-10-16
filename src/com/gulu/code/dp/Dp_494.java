package com.gulu.code.dp;

import java.util.Arrays;

/**
 * 背包问题：目标和
 *
 * @author chocolate
 * 2024/10/14 17:10
 */
public class Dp_494 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(doDp494(nums, target));
    }

    private static int doDp494(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        // 目标和大于物品和，目标和加物品和不是偶数，
        if (target > sum || -target > sum || (sum + target) % 2 != 0) {
            return 0;
        }
        int total = (sum + target) >> 1;
        int[] dp = new int[total + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = dp.length - 1; j >= nums[i]; j--) {
                dp[j] = dp[j] + dp[j - nums[i]];
            }
        }
        return dp[total];

    }


    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if ((target < 0 && sum < -target) || (target > sum)) {
            return 0;
        }
        sum += target;
        if (sum % 2 != 0) {
            return 0;
        }
        int[] dp = new int[(sum >> 1) + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = dp.length - 1; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[dp.length - 1];
    }
}
