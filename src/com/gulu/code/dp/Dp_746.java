package com.gulu.code.dp;

/**
 * 最小花费爬楼梯
 *
 * @author chocolate
 * 2024/9/24 17:26
 */
public class Dp_746 {

    public static void main(String[] args) {
        int[] nums = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(nums));
    }

    public static int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        return dp[cost.length - 1];
    }
}
