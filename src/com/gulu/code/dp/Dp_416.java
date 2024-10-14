package com.gulu.code.dp;

import java.util.Arrays;

/**
 * 分割等和子集
 * <p>
 * 背包问题，能不能正好装满背包问题
 *
 * @author chocolate
 * 2024/10/12 17:22
 */
public class Dp_416 {
    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};

        System.out.println(do416(nums));
    }

    private static boolean do416(int[] nums) {
        int sum = Arrays.stream(nums).sum();

        if (sum % 2 != 0) {
            return false;
        }

        sum = sum >> 1;

        int[] dp = new int[sum + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = sum; j - nums[i] >= 0; j--) {
                dp[j] = Math.max(nums[i] + dp[j - nums[i]], dp[j]);
            }
        }
        return dp[sum] == sum;
    }


}
