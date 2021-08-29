//Time complexity: O(mn)
//Space complexity: O(m)
//DP approach using adiitional array instead of matrix

class maximalSqr {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return 0;
        
        int m = matrix.length, n = matrix[0].length;
        int max = 0, prev = 0;
        int[] dp = new int[n + 1];
        
        for(int i = 1; i < m + 1; i++){
            for(int j = 1; j < n + 1; j++){
                if(matrix[i - 1][j - 1] == '1'){
                    int temp = dp[j];
                    dp[j] = Math.min(dp[j], Math.min(dp[j - 1], prev)) + 1;
                    prev = temp;
                    
                    
                }
                else{
                    dp[j] = 0;
                }
                max = Math.max(max, dp[j]);
            }
        }
        
        return max*max;
    }
}