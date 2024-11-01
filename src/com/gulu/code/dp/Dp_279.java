package com.gulu.code.dp;

/**
 * 完全平方数
 *
 * 完全背包，物品无限
 *
 * @author chocolate
 * 2024/10/31 15:00
 */
public class Dp_279 {

    public static void main(String[] args) {
        int num = 13;
        System.out.println(numSquares(num));
    }

    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = i;
        }
        for (int i = 2; i * i <= n; i++) {
            for (int j = i * i; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }
        return dp[n];
    }
}
