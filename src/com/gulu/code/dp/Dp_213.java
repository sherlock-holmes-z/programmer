package com.gulu.code.dp;

/**
 * 打家劫舍2
 *
 * @author chocolate
 * 2024/11/5 16:50
 */
public class Dp_213 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        int[] dp0 = new int[nums.length];
        int[] dp1 = new int[nums.length];
        if (nums.length > 1) {
            dp0[0] = nums[0];
            dp0[1] = Math.max(nums[0], nums[1]);

            dp1[1] = nums[1];
        } else {
            return nums[0];
        }
        for (int i = 2; i < nums.length; i++) {
            if (i < nums.length - 1) {
                dp0[i] = Math.max(dp0[i - 2] + nums[i], dp0[i - 1]);
            }
            dp1[i] = Math.max(dp1[i - 2] + nums[i], dp1[i - 1]);
        }
        return Math.max(dp0[nums.length - 2], dp1[nums.length - 1]);
    }

    public int rob2(int[] nums) {
        int[] dp0 = new int[nums.length];
        int[] dp1 = new int[nums.length];
        if (nums.length > 1) {
            dp0[0] = nums[0];
            dp0[1] = nums[0];

            dp1[1] = nums[1];
        }else {
            return nums[0];
        }
        for (int i = 2; i < nums.length; i++) {
            if (i < nums.length - 1) {
                dp0[i] = Math.max(dp0[i - 2] + nums[i], dp0[i - 1]);
            }
            dp1[i] = Math.max(dp1[i - 2] + nums[i], dp1[i - 1]);

        }
        return Math.max(dp0[nums.length - 2], dp1[nums.length - 1]);
    }

}
