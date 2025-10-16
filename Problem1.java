// Time Complexity : O(m * n)^2 where m and n are the dimensions of the matrix. mn for traversing the grid and mn in worse case where there are all 1s in the grid
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * Traversing the matrix. Traversing diagonally from each index to see if it is 1. If it is 1, then we check all columns and rows if they are 1s. If they are one, then we go one step one more step further and keep track of max level.
 */
class BruteForceSolution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int max = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    int le = 1;
                    boolean flag = true;

                    while (i + le < m && j + le < n) {

                        //check rows
                        for (int k = i + le; k >= i; k--) {
                            if (matrix[k][j + le] == '0') {
                                flag = false;
                                break;
                            }
                        }

                        //check columns
                        for (int k = j + le; k >= j; k--) {
                            if (matrix[i + le][k] == '0') {
                                flag = false;
                                break;
                            }
                        }

                        // match found so move to next level
                        if (flag) le++;
                            // match not found so we shouldn't move ahead
                        else break;
                    }

                    max = Math.max(max, le);
                }
            }
        }

        return max * max;
    }
}

// Time Complexity : O(m * n) where m and n are the dimensions of the matrix since we are traversing the matrix once
// Space Complexity : O(m * n) for dp matrix
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * Using bottom up dp and starting from last entry on the matrix. For every 1, adding 1 to the minimum number of square that can be formed in right, down and diagonal-down.
 */
class DpSolution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int max = 0;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    // checking the minimum valid square in right, bottom and horizontal since that determines the maximum size of the square that can be formed at current index
                    dp[i][j] = 1 + Math.min(dp[i + 1][j], Math.min(dp[i][j + 1], dp[i + 1][j + 1]));
                    max = Math.max(dp[i][j], max);
                }
            }
        }

        return max * max;
    }
}