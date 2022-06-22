class Solution {
    // Dynamic solution
    // Time complexity is O(mn)
    // Space complexity is O(1)
    // This solution is submitted on leetcode with zero error
    public int maximalSquare(char[][] matrix) {
        // Edge case
        if(matrix == null || matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[][]dp = new int[m+1][n+1];
        for(int i = 1; i<dp.length ; i++){
            for(int j = 1; j<dp[0].length;j++){
                if(matrix[i-1][j-1] == '1'){
                    int temp = Math.min(dp[i][j-1], dp[i-1][j]);
                    dp[i][j] = Math.min(temp, dp[i-1][j-1]) +1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max*max;
    }
}