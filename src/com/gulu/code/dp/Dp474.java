package com.gulu.code.dp;

/**
 * 一和零
 * <p>
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 * 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1
 *
 * @author chocolate
 * 2024/10/24 14:35
 */
public class Dp474 {

    public static void main(String[] args) {
        String[] str = {"10", "0001", "111001", "1", "0"};
        System.out.println(findMaxForm(str, 5, 3));
    }

    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (String str : strs) {
            int num0 = 0, num1 = 0;
            for (char s : str.toCharArray()) {
                if (s == '0') {
                    num0++;
                } else {
                    num1++;
                }
            }

            for (int i = m; i >= num0; i--) {
                for (int j = n; j >= num1; j--) {
                    dp[i][j] = Math.max(dp[i- num0][j - num1] + 1,dp[i][j]);
                }
            }
        }
        return dp[m][n];
    }
}

