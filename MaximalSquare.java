package DP4;

/*
    -------------------------------------------------------------------------------------------------------
    Time complexity : o(mn) with dp matrix
    space complexity: o(mn) if we use a new dp matrix
    Did this code run successfully in leetcode : yes
    problems faces : no
    */

public class MaximalSquare {

    public int maximalSquareBruteForce(char[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = false;
                if (matrix[i][j] == '1') {
                    int current = 1; // dimension to traverse diagonally to bottom right element
                    flag = true;
                    while (i + current < m && j + current < n && flag) {
                        //check if the if we have encountered 0 in the same column of our diagonal element
                        for (int k = i + current; k >= i; k--) {
                            if (matrix[k][j + current] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        for (int k = j + current; k >= j; k--) {
                            if (matrix[i + current][k] == '0') {
                                flag = false;
                                break;
                            }
                        }

                        if (flag) {
                            current++;
                        }
                    }
                    max = Math.max(max, current);
                }
            }
        }
        return max * max;
    }

    public int maximalSquareDP(char[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {

                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
}
