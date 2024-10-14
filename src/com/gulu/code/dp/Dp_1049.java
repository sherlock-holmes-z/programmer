package com.gulu.code.dp;

import java.util.Arrays;

/**
 * 最后一块石头的重量
 * 背包问题：装满背包的最大重量
 * <p>
 * 思路：尽量将石头分成相近的两堆，相撞之后剩下的石头最小
 *
 * @author chocolate
 * 2024/10/14 15:30
 */
public class Dp_1049 {

    public static void main(String[] args) {
//        int[] nums = {2, 7, 4, 1, 8, 1};
        int[] nums = {31,26,33,21,40};
        System.out.println(doDp1049(nums));
    }

    private static int doDp1049(int[] nums) {
        int sum = Arrays.stream(nums).sum();

        int[] dp = new int[sum / 2 + 1];

        for (int i = 0; i < nums.length; i++) {
            for (int j = dp.length - 1; j - nums[i] >= 0; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return Math.abs(sum - dp[dp.length - 1] * 2);
    }
}
