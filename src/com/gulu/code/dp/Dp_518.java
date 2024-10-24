package com.gulu.code.dp;

/**
 * 零钱兑换2
 *
 * 求组合外层遍历背包，内层遍历物品
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
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j < dp.length; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}
