/**
 * Leetcode 221. Maximal Square
 * Link: https://leetcode.com/problems/maximal-square/description/
 */
//------------------------------------ Solution 1 -----------------------------------
public class MaximalSquare {
    /**
     * Brute Force Solution: In nested iteration find each 1 in the matrix. For each 1 find the maximum possible square
     * by moving diagonally and checking same row and column from that new diagonal cell for all 1s in each direction.
     * Keep moving until bounds are reached or square isn't containing all 1s. Keep track of maximum length of the square.
     *
     * TC: O(m*n*min(m*n)^2)
     * SC: O(1)
     */
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    int l = 1;
                    boolean flag = true;
                    while (i + l < m && j + l < n && flag) {
                        //check same row from diagonal element
                        for (int y = j + l; y >= j; y--) {
                            if (matrix[i + l][y] != '1') {
                                flag = false;
                                break;
                            }
                        }

                        //check same column from diagonal element
                        for (int x = i + l; x >= i; x--) {
                            if (matrix[x][j + l] != '1') {
                                flag = false;
                                break;
                            }
                        }

                        if (flag) { //valid square
                            l++;
                        }
                    }
                    max = Math.max(max, l);
                }
            }
        }
        return max*max;
    }
}

//------------------------------------ Solution 2 -----------------------------------
class MaximalSquare2 {
    /**
     * 2D matrix DP solution: We process given matrix bottom up and keep track of the maximum squares formed by each cell.
     * The way we do it is by taking left, right, diagonal down cells, get minimum of the maximum squares each  cell
     * formed in previous calculation. And continuously update the 2D DP matrix with current cell's calculated maximum and
     * the global maximum. Note we are taking (m+1)*(n+1) DP matrix initially so additional dummy row and column are default
     * value 0 which is consistent with the logic. This avoids bound check complexity.
     *
     * TC: O(m*n)
     * SC: O(m*n)
     */
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int max = 0;
        for (int i =  m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i][j + 1], Math.min(dp[i + 1][j], dp[i + 1][j + 1]));
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max*max;
    }
}

//------------------------------------ Solution 3 -----------------------------------
class MaximalSquare3 {
    /**
     * Optimized 1D DP solution: we only need 1D DP as we depend on down,left and diagonal. left will be the updated
     * calculation from just previous cell in same row. down will the current dp cell itself and diagonal will be the
     * previous value of left before it was overridden.
     *
     * TC: O(m*n)
     * SC: O(n)
     */
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] dp = new int[n + 1];
        int max = 0;
        for (int i =  m - 1; i >= 0; i--) {
            int diagonal = 0;
            for (int j = n - 1; j >= 0; j--) {
                int temp = dp[j]; //current will be overwritten and we need to store it as diagonal for next iteration
                if (matrix[i][j] == '1') {
                    dp[j] = 1 + Math.min(dp[j], Math.min(dp[j + 1], diagonal));
                    max = Math.max(max, dp[j]);
                } else {
                    dp[j] = 0;
                }
                diagonal = temp; // set diagonal for next iteration
            }
        }
        return max*max;
    }
}