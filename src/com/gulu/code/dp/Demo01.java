package com.gulu.code.dp;

import javax.crypto.Mac;
import java.util.Arrays;

/**
 * 01背包问题
 * <p>
 * 有n件物品和一个最多能背重量为w 的背包
 * 第i件物品的重量是weight[i]，得到的价值是value[i]
 * 每件物品只能用一次，求解将哪些物品装入背包里物品价值总和最大
 *
 * @author chocolate
 * 2024/10/10 15:45
 */
public class Demo01 {

    public static void main(String[] args) {
        int[] w = {1, 3, 4};
        int[] v = {15, 20, 30};
        int weight = 4;
        System.out.println(doDp01(w, v, weight));
    }

    private static int doDp01(int[] w, int[] v, int weight) {
        int[][] dp = new int[w.length + 1][weight + 1];
        for (int i = 1; i < w.length + 1; i++) {
            for (int j = 1; j < weight + 1; j++) {
                if (j < w[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i - 1]] + v[i - 1]);
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[w.length][weight];
    }


}
