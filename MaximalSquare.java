class MaximalSquare {
  /**
    Dynamic Programming - Optimized for space.
    
    Time Complexity: O(m * n)
    Space Complexity: O(n)
    */
    public int maximalSquare(char[][] matrix) {
      int[] dp = new int[matrix[0].length+1];
      
      int max = 0;
      
      for(int i = 1; i < matrix.length+1; i++) {
          int diag = 0;
          for(int j = 1; j < dp.length; j++){
              int temp = dp[j];
              if(matrix[i-1][j - 1] == '1'){
                  dp[j] = 1 + Math.min(dp[j], Math.min(dp[j-1], diag));
                  max = Math.max(max, dp[j]);
                  diag = temp;
              } else {
                  dp[j] = 0;
              }
              
          }
      }
      
      return max * max;
      
  }
  
  /**
  Dynamic Programming Top - Down approach
  
  Time Complexity: O(m * n)
  Space Complexity: O(m * n)
      -> for the DP array.
  
  */
  public int maximalSquare(char[][] matrix) {
      int m = matrix.length, n = matrix[0].length;
      
      int max = 0;
      int[][] dp = new int[m+1][n+1];
      
      for(int i = 1 ; i < m+1; i++) {
          for(int j = 1; j < n+1; j++) {
              if(matrix[i-1][j-1] == '1'){
                  dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                  max = Math.max(max, dp[i][j]);
              }
              
          }
      }
      
      return max * max;
  }
}