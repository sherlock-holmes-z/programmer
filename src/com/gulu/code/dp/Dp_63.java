package com.gulu.code.dp;

/**
 * 不同路径 2
 *
 * @author chocolate
 * 2024/9/25 16:42
 */
public class Dp_63 {
    public static void main(String[] args) {
        int[][] nums = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(uniquePathsWithObstacles(nums));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int h = obstacleGrid.length;
        int w = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[h-1][w-1] == 1){
            return 0;
        }
        int[][] dp = new int[h+1][w+1];
        dp[1][1] = 1;
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= w; j++) {
                if (i ==1 && j ==1 ){
                    continue;
                }
                if (obstacleGrid[i-1][j-1] == 1){
                    dp[i][j] = 0;
                }else {
                    dp[i][j] = dp[i-1][j] + dp[i][j -1];
                }
            }
        }
        return dp[h][w];
    }
}
