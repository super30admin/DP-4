class Solution {
    public int maximalSquare(char[][] matrix) {
        
        // Time Complexity :: O(m*n)- Bruteforce appraoch traversing through diagonals
        // Space Complexity :: O(n)
        
        // rows
        int m = matrix.length;
        
        // columns
        int n = matrix[0].length;
        
        int max = 0;
        int diagonal = 0;
        
        // 1D array
        int[] dp = new int[n+1];
        
        for (int i = 1 ; i<=m; i++){
            
            for(int j = 1 ; j <= n ; j++){
                
                // If 1 , check for the next diagonal element 
                if (matrix[i-1][j-1] == '1'){
                    
                    // store it to compare it in future
                    int temp = dp[j];
                    
                    dp[j] = Math.min(dp[j] , dp[j-1]);
                    dp[j] = Math.min(dp[j] , diagonal) + 1;
                    
                    diagonal = temp;
                    
                    max = Math.max(max, dp[j]);
                    
                }
                else{
                    dp[j] = 0;
                }
            }
        }
        
        return max * max;
    }
}