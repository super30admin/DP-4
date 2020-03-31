// Time Complexity : O(m*n) m - > no. of rows, n -> no. of cols
// Space Complexity : O(m*n) additional space for DP matrix
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach:
// If a number is 0, then that number cannot form any square and cannot be part of any square.
// If a number is 1, then the minimum square it can form is of size 1. To go a step further, if we consider any 2*2 plot, then for the plot to form a square of size 2, all its neighbors must be 1.
// Considering this concept, let's assume each number to be the rightmost bottom corner of a 2*2 plot and check iteratively if making a square is possible or not, if possible then how many.

class Solution {
    public int maximalSquare(char[][] matrix) {
        // edge case
        if(matrix == null || matrix.length == 0)
            return 0;
        
        int[][] dp = new int[matrix.length][matrix[0].length]; // DP matrix
        int max = 0;
        // if any of the neighbor is 0 or out of bounds, then neighbor contribution = 0
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == '0') {
                    dp[i][j] = 0;
                }
                else if(i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j]-'0';
                }
                else {
                    dp[i][j] = (Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]))) + (matrix[i][j] - '0');
                }
                max = Math.max(max, dp[i][j]);
            }  
        }
        return max*max;
    }
}

