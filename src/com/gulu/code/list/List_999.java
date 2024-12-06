package com.gulu.code.list;

/**
 * 可以被一步捕获的棋子数
 *
 * @author chocolate
 * 2024/9/24 15:25
 */
public class List_999 {

    public static void main(String[] args) {
        char[][] board = {
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'p', 'p', '.', 'R', '.', 'p', 'B', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'B', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                 {'.', '.', '.', '.', '.', '.', '.', '.'}
        };
        System.out.println(numRookCaptures(board));
    }

    public static int numRookCaptures(char[][] board) {
        int x = 0, y = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if ('R' == board[i][j]) {
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        int sum = 0;
        boolean up = false;
        boolean down = false;
        boolean left = false;
        boolean right = false;
        for (int i = 1; i < 8; i++) {
            if (!up && x + i < 8) {
                if (board[x + i][y] == 'p') {
                    sum++;
                    up = true;
                } else if (board[x + i][y] == 'B') {
                    up = true;
                }
            }
            if (!down && x - i >= 0) {
                if (board[x - i][y] == 'p') {
                    sum++;
                    down = true;
                } else if (board[x - i][y] == 'B') {
                    down = true;
                }
            }
            if (!left && y - i >= 0) {
                if (board[x][y - i] == 'p') {
                    sum++;
                    left = true;
                } else if (board[x][y - i] == 'B') {
                    left = true;
                }
            }
            if (!right && y + i < 8) {
                if (board[x][y + i] == 'p') {
                    sum++;
                    right = true;
                } else if (board[x][y + i] == 'B') {
                    right = true;
                }
            }
        }
        return sum;
    }
}
