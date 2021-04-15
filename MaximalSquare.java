// Time Complexity : O(n*m)..where m is the number of rows and n is the number of columns
// Space Complexity :O(n*m) to store the elements in the dp array
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach


class Solution {
    public int maximalSquare(char[][] matrix) {
      
      if(matrix == null || matrix.length==0 || matrix[0].length==0)
      {
        return 0;
      }
      
      int m = matrix.length;
      int n = matrix[0].length;
      
      int[][] dp = new int [m+1][n+1];
      int max = 0;
      for(int i=1;i<dp.length;i++)
      {
        for(int j=1;j<dp[0].length;j++)
        {
          //only if we see a '1' in the input matrix 
          if(matrix[i-1][j-1]=='1')
          {
            //get the minimum and add one from the left top and left top diagonal
            dp[i][j] = 1 + Math.min(dp[i][j-1],(Math.min(dp[i-1][j],dp[i-1][j-1])));
            //keep updating the max
            max = Math.max(max , dp[i][j]);
          }
        }
      }
        
      return max * max;
    }
}