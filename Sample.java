//Time Complexity:O(mn)
//Space Complexity:O(mn)

public class Solution {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        
        int[][] dp = new int[rows + 1][cols + 1];
        
        int maxsqlen = 0;
        for (int i = 1; i <= rows; i++) {
        
            for (int j = 1; j <= cols; j++) {
            
                if (matrix[i-1][j-1] == '1'){

        dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
        
                    maxsqlen = Math.max(maxsqlen, dp[i][j]);
                
                }
            
            }
            
        }
        
        return maxsqlen * maxsqlen;
    }
}

-------------------------------------------------------------------------------------
// Time Complexity - O(n*K) where n is the length of A
// Space Complexity - O(n) 

class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {
        if(A == null || A.length ==0)   return 0;
        int n = A.length;
        int[] dp = new int[n];
        for(int i=0;i< n;i++){
            int max =0;
            for(int j = 1;j <= K && i-j+1 >=0;j++){
                max = Math.max(max,A[i-j+1]);
                dp[i] = Math.max(dp[i], (i >= j?dp[i-j]:0)+max*j);
            }
        }
        return dp[n-1];
    }
}


------------------------------------------------------------------------