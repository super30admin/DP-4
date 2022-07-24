//TC -O(m*n)
//SC -O(m*n)
class Solution {
    public int maximalSquare(char[][] matrix) {
      // null
        int m = matrix.length; int n = matrix[0].length;
        int max = 0;
        int [] dp = new int[n+1];
        for(int i = 1; i <= m; i++){
            int diagUp = 0;
            for(int j = 1; j <= n; j++){
                 int temp = dp[j];
                if(matrix[i-1][j-1] == '1'){
                    dp[j] = 1 + Math.min(dp[j], Math.min(dp[j-1], diagUp));
                    max = Math.max(dp[j], max);
                } else {
                    dp[j] = 0;
                }
                diagUp = temp;
            }
        }
        
        return max*max;
    }
}
