package com.gulu.code.dp;

/**
 * 买卖股票的最佳时机
 *
 * @author chocolate
 * 2024/11/6 16:25
 */
public class Dp_121 {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfit2(prices));
    }

    /**
     * 贪心方式，从左向右遍历，取当前最大值减取左边最小值
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int min = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }

    /**
     * 动规方式
     *
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.min(prices[i], dp[i - 1][0]);
            dp[i][1] = Math.max(prices[i] - dp[i - 1][0], dp[i - 1][1]);
        }
        return dp[prices.length - 1][1];
    }
}
