package com.gulu.code.dp;

import java.util.Arrays;

/**
 * 零钱兑换
 * 完全背包问题，求最小组合情况
 *
 * @author chocolate
 * 2024/10/25 10:34
 */
public class Dp_322 {

    public static void main(String[] args) {
//        int[] coins = {1, 2, 5};
//        int amount = 11;

        int[] coins = {474, 83, 404, 3};
        int amount = 264;
        System.out.println(coinChange(coins, amount));
    }


    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1 < 0 ? dp[i - coins[j]] : dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j < dp.length; j++) {
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1 < 0 ? dp[j - coins[i]] : dp[j - coins[i]] + 1);
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
