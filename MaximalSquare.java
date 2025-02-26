//Time complexity : O(m*n)
//Space complexity  : O(n)

class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null){
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[] dp = new int[n+1];
        for(int i=0;i<m;i++){
            int temp = dp[0];
            for(int j = 1;j<n+1; j++){
                int prev = dp[j];
                if(matrix[i][j-1] ==  '1'){
                    dp[j] = Math.min(dp[j-1],Math.min(dp[j],temp)) +1;
                    max  = Math.max(max,dp[j]);
                }else{
                    dp[j] = 0;
                }
                temp =prev;
            }
        }
        return max*max;
    }
}