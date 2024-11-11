package com.gulu.code.dp;

/**
 * 买卖股票的最佳时机2
 *
 * @author chocolate
 * 2024/11/7 16:48
 */
public class Dp_122 {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfit2(prices));
    }

    /**
     * 贪心方式：有收益就卖出
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                sum += prices[i] - prices[i - 1];
            }
        }
        return sum;
    }


    /**
     * 动规
     *
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {
        int[][] dp = new int[2][prices.length];
        dp[0][0] = -prices[0];
        dp[1][0] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[0][i] = Math.max(dp[1][i - 1] - prices[i], dp[0][i - 1]);
            dp[1][i] = Math.max(dp[0][i - 1] + prices[i], dp[1][i - 1]);
        }
        return dp[1][prices.length - 1];
    }

}
