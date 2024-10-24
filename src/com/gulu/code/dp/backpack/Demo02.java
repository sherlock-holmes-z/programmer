package com.gulu.code.dp.backpack;


/**
 * 完全背包问题
 * 有n件物品和一个最多能背重量为w 的背包 第i件物品的重量是weight[i]，得到的价值是value[i]
 * 每件物品有无限个，求解将哪些物品装入背包里物品价值总和最大
 * <p>
 * （与01背包的不同就是物品有无限个）
 *
 * @author chocolate
 * 2024/10/12 15:15
 */
public class Demo02 {

    public static void main(String[] args) {
        int[] w = {1, 3, 4};
        int[] v = {15, 20, 30};
        int weight = 4;
        System.out.println(doCompleteDp01(w, v, weight));
    }

    private static int doCompleteDp01(int[] w, int[] v, int weight) {
        int[] dp = new int[weight + 1];
        for (int i = 0; i < w.length; i++) {
            for (int j = 1; j < dp.length && j >= w[i] ; j++) {
                   dp[j] = Math.max(dp[j - 1],dp[j - w[i]] + v[i]);
            }
        }
        return dp[weight];
    }

}
