package com.gulu.code.dp;

/**
 * 整数拆分
 *
 * @author chocolate
 * 2024/9/29 15:20
 */
public class Dp_343 {

    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }

    public static int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 4;
        int result = 1;
        while (n > 4) {
            result = result * 3;
            n -= 3;
        }
        return result * n;
    }
}
