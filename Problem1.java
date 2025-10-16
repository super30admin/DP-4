// Time Complexity : O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//We use tabulation approach as we see repetative subproblems to calculate maximal square
//We start off with the bottom row and right most column and find number of squares
//if to its right, bottom and diagonal the char is 1 then maximum square that cell can have is minimum among right, bottom and diagonal plus 1
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i][j + 1], Math.min(dp[i + 1][j], dp[i + 1][j + 1])) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;

    }
}
