package com.gulu.code.dp;

/**
 * 斐波那契数
 *
 * @author chocolate
 * 2024/9/24 16:41
 */
public class Dp_509 {

    public static void main(String[] args) {
        int num =  getFib(10);
        System.out.println(num);
    }

    private static int getFib(int n) {
        if (n == 0 || n == 1){
            return n;
        }
        int p1 = 0;
        int p2 = 1;
        int temp;
        for (int i = 2; i <= n; i++) {
            temp = p1 + p2;
            p1 = p2;
            p2 = temp;
        }
        return p2;
    }
}
