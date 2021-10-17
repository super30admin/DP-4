// Time Complexity :O(mn^2)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach
// take a dp matrix of row+1,col+1 size
// start from 1,1 index of dp matrix and check if value of this index which is (i-1,j-1) in origin matrix is one or not . if it is one then compare (top,prev and diagnol element in dp matrix) pick smallest value and plus 1;
// keep saving maxlength scuh that max(maxlength, dp[i,j]
// return maxlength * maxlength


class Solution {
    public int maximalSquare(char[][] matrix) {
    
        int row = matrix.length;
        int col = matrix[0].length;
        int maxsqr =0;
        int[][] dp = new int[row+1][col+1];
        
        for(int i =1; i <= row; i++)
        {
            for(int j =1; j <= col;j++)
            {
                if(matrix[i-1][j-1]=='1')
                {
                    dp[i][j] = Math.min(Math.min(dp[i][j-1],dp[i-1][j]),dp[i-1][j-1]) +1;
                    maxsqr = Math.max(maxsqr,dp[i][j]);
                }
            }
        }
        
        return maxsqr * maxsqr;
    }
}