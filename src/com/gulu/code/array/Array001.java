package com.gulu.code.array;

/**
 * 二分查找
 *
 * @author chocolate
 * 2024/9/24 15:20
 */
public class Array001 {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int index = getIndex(nums, 2);
        System.out.println(index);
    }

    private static int getIndex(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

}
