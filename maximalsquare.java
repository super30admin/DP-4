// TC : O(m*n)
// SC : O(n)

// OPTIMISED DP

class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        
        int max = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int prev = 0;
        int temp = 0;
        int[] dp = new int[n+1];
        
        for (int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                temp = dp[j];
                if(matrix[i-1][j-1] == '1'){
                    dp[j] = Math.min(dp[j-1],Math.min(dp[j],prev)) + 1;
                    max = Math.max(max,dp[j]);
                }
                else{
                    dp[j] = 0;
                }
                prev = temp;
            }
        }
        return max*max;
    }
}