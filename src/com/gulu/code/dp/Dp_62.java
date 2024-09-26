package com.gulu.code.dp;

/**
 * 不同路径
 *
 * @author chocolate
 * 2024/9/25 15:32
 */
public class Dp_62 {

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
    }


    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
