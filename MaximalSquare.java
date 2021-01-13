/**
 * TC: O(mn)
 * SC: O(mn)
 * LeetCode: Y(https://leetcode.com/problems/maximal-square/)
 * Approach: Save the length of maximum square possible at matrix[i][j] at dp[i + 1][j + 1]
    A larger square at dp[i][j] is possible only when the top, left and diagonal element is 1
    So dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1],dp[i - 1][j])) + 1
 */

class Solution {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length,maxSquareLength = 0;
        // Initailize dp matrix
        int[][] dp = new int[rows + 1][cols + 1];
        
        // Populate the dp matrix one cell at a time
        for(int i = 1 ; i < dp.length ; i++) {
            for(int j = 1 ; j < dp[0].length ; j++) {
                // if current cell being processed is a 1
                if(matrix[i - 1][j - 1] == '1') {
                   // get the minimum of top, left and diagonal cell and add 1 
                  dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1],dp[i - 1][j])) + 1; 
                  // Update maxSquareLength if possible  
                  maxSquareLength = Math.max(maxSquareLength, dp[i][j]);
                }
                
            }
        }
        // return the area of the largest square
        return maxSquareLength * maxSquareLength;
    }
}
