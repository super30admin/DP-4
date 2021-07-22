//Time complexity - O(m*n)
//Space complexity - O(m*n)

class Solution {
    public int maximalSquare(char[][] matrix) {
      
      if(matrix == null || matrix.length == 0) return 0;
      int m = matrix.length; int n = matrix[0].length;
      int max = 0;
      int[][] dp = new int [m+1][n+1]; 
      for(int i = 1;i<dp.length;i++) {
        for(int j = 1; j< dp[0].length; j++) {
          if(matrix[i-1][j-1] == '1') { 
            //since there are repeating sub problems use the data which is already calculated.
            //if matrix element is 1 then find min between left, top and top diagonal element and then add 1
            dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j],dp[i-1][j-1])) +1; 
            System.out.println(i+","+j);
            //record the max length of square
            max = Math.max(max,dp[i][j]);
          }
        }
      }
        return max*max;
    }
}