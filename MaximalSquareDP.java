/*
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(m*n)
* 
* Space Complexity: O(m*n)
* 
*/

class MaximalSquareDP {
    int maxSquareSize = 0;

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;

        int n = matrix[0].length;

        int[][] dp = new int[m][n];

        for (int row = m - 1; row >= 0; row--) {
            for (int col = n - 1; col >= 0; col--) {
                if (matrix[row][col] == '1') {
                    int diag = 0, right = 0, down = 0;

                    if (row + 1 < m && col + 1 < n) {
                        diag = dp[row + 1][col + 1];
                    }

                    if (row + 1 < m) {
                        down = dp[row + 1][col];
                    }

                    if (col + 1 < n) {
                        right = dp[row][col + 1];
                    }

                    dp[row][col] = Math.min(Math.min(down, right), diag) + 1;

                    maxSquareSize = Math.max(maxSquareSize, dp[row][col]);
                }
            }
        }

        return maxSquareSize * maxSquareSize;
    }
}