// Time Complexity : O(mn)2
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We traverse through the matrix
// Whereever we find the 1, we put a loop and check the right and left directions for 1
// We update the max value in the process and return the square

class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    boolean valid = true;
                    int curr = 1;
                    while (i + curr < m && j + curr < n && valid) {
                        for (int k = j; k <= j + curr; k++) {
                            if (matrix[i + curr][k] == '0') {
                                valid = false;
                                break;
                            }
                        }
                        for (int k = i; k <= i + curr; k++) {
                            if (matrix[k][j + curr] == '0') {
                                valid = false;
                                break;
                            }
                        }
                        if (valid)
                            curr++;
                    }
                    max = Math.max(max, curr);
                }
            }
        }
        return max * max;
    }
}

// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We solve this using dp
// we create a 2d array that stores the number of 1's by checking up left and
// diagonal
// We update the max in the process
// we return the square of the max
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max * max;
    }
}

// Time Complexity : O(mn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We solve this using dp
// Instead of 2d array that stores the number of 1's by checking up left and
// diagonal, we use a 1D array
// We update the max in the process
// we return the square of the max
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[] dp = new int[n + 1];
        int diagUp = 0;
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    int prev = dp[j];
                    dp[j] = Math.min(dp[j - 1], Math.min(dp[j], diagUp)) + 1;
                    max = Math.max(dp[j], max);
                    diagUp = prev;
                } else {
                    dp[j] = 0;
                }
            }
        }
        return max * max;
    }
}