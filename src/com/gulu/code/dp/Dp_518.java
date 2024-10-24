package com.gulu.code.dp;

/**
 * 零钱兑换2
 *
 * @author chocolate
 * 2024/10/24 16:10
 */
public class Dp_518 {
    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2, 5};
        System.out.println(change(amount, coins));
    }

    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j < dp.length && j >= coins[i]; j++) {
                dp[j] = Math.max(dp[j - 1], dp[j - coins[i]] + 1);
            }
        }
        return dp[amount];
    }
}
