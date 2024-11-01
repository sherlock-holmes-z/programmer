package com.gulu.code.dp;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 执行操作可获得的最大总奖励
 * 01背包
 * @author chocolate
 * 2024/10/25 21:50
 */
public class Dp_3180 {
    public static void main(String[] args) {
        // 11
//        int[] rewardValues = {1, 6, 4, 3, 2};

        // 35
        int[] rewardValues = {7, 8, 3, 20};
        System.out.println(maxTotalReward(rewardValues));
    }

    // 数组过大会超时，方法有待改进
    public static int maxTotalReward1(int[] rewardValues) {
        Arrays.sort(rewardValues);
        int sum = Arrays.stream(rewardValues).sum();
        int[] dp = new int[sum + 1];

        for (int i = 0; i < rewardValues.length; i++) {
            for (int j = dp.length - 1; j >= rewardValues[i]; j--) {
                if (dp[j - rewardValues[i]] < rewardValues[i]) {
                    dp[j] = Math.max(dp[j], dp[j - rewardValues[i]] + rewardValues[i]);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public static int maxTotalReward(int[] rewardValues) {
        Arrays.sort(rewardValues);
        int max = rewardValues[rewardValues.length - 1];
        int[] dp = new int[2 * max];

        for (int i = 0; i < rewardValues.length; i++) {
            for (int j = dp.length - 1; j >= rewardValues[i]; j--) {
                if (dp[j - rewardValues[i]] < rewardValues[i]) {
                    dp[j] = Math.max(dp[j], dp[j - rewardValues[i]] + rewardValues[i]);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
