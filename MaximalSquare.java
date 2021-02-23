package DP-4;
// Time Complexity : O(n*m)
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
public class MaximalSquare {
    class Solution {
        public int maximalSquare(char[][] matrix) {
            if(matrix.length == 0) return 0;
            int row = matrix.length, col = matrix[0].length;
            
            int[][] dp = new int[row+1][col+1];
            int max = 0;
            for(int i = 1; i <= row; i++){
                for(int j = 1; j <= col; j++){
                    if(matrix[i-1][j-1] == '1'){
                        dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                        max = Math.max(max, dp[i][j]);
                    }
                }
            }
            
            return max * max;
        }
    }
}
