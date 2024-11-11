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
}
