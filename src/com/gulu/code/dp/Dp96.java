package com.gulu.code.dp;

/**
 * 不同的二叉搜索树
 *
 * @author chocolate
 * 2024/10/10 15:16
 */
public class Dp96 {

    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }


    public static int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}
