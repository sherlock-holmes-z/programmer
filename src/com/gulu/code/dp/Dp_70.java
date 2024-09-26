package com.gulu.code.dp;

/**
 * 爬楼梯
 *
 * @author chocolate
 * 2024/9/24 17:10
 */
public class Dp_70 {
    public static void main(String[] args) {
        System.out.println(getNum(10));
    }

    private static int getNum(int n) {
        int p1, p2 = 0, r = 1;
        for (int i = 0; i < n; i++) {
            p1 = p2;
            p2 = r;
            r = p1 + p2;
        }
        return r;
    }
}
