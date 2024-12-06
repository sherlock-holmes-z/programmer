package com.gulu.code.dp;

/**
 * 买卖股票的最佳时机含冷冻期
 *
 * @author chocolate
 * 2024/11/25 15:16
 */
public class Dp_309 {

    public static void main(String[] args) {
        int[] price = {1, 2, 3, 0, 2};
        System.out.println(maxProfit(price));
    }

    public static int maxProfit(int[] prices) {
        int[][] dp = new int[2][prices.length + 1];
        dp[0][1] = -prices[0]; // 第一天持有股票
        dp[1][1] = 0; // 第一天不持有股票
        for (int i = 2; i < prices.length + 1; i++) {
            dp[0][i] = Math.max(dp[1][i - 2] - prices[i - 1], dp[0][i - 1]); // 卖出股票后隔一天再持有
            dp[1][i] = Math.max(dp[0][i - 1] + prices[i - 1], dp[1][i - 1]);
        }
        return dp[1][prices.length];
    }

}
