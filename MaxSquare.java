// Time Complexity :O(mn^2)
// Space Complexity :constat
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

//at each index we are going down right diagonally and calculating maximum size of square
class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int maxS = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int l = 1;
                boolean isZeroFound = false;
                if (matrix[i][j] == '1') {

                    while (i + l < n && j + l < m && !isZeroFound) {
                        for (int a = i + l; a >= i; a--) {
                            if (matrix[a][j + l] == '0') {
                                isZeroFound = true;
                                break;
                            }
                        }
                        for (int b = j + l; b >= j; b--) {
                            if (matrix[i + l][b] == '0') {
                                isZeroFound = true;
                                break;
                            }
                        }

                        if (!isZeroFound)
                            l++;
                    }
                    maxS = Math.max(maxS, l);
                }

            }
        }
        return maxS * maxS;
    }
}

// --------------------DP solution----------------------------
// Time Complexity :O(mn)
// Space Complexity :O(mn)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No

// in dp matrix, we'll store size of maximum square . for that, we'll take
// minimum from its right
// bottom and diagonal bottom right because if any one of them is zero, we
// cannot make square of ones
// at the end, we'll return maximum size
class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int maxS = 0;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i + 1][j], dp[i][j + 1]), dp[i + 1][j + 1]) + 1;
                    maxS = Math.max(maxS, dp[i][j]);
                }
            }
        }
        return maxS * maxS;
    }
}
