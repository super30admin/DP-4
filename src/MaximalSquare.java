// Create a dp array to get the size of maximum square which can be formed
// TC: O(m*n)
// SC: O(m*n)
class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int [][] dp = new int[m+1][n+1];
        for(int i=m-1;i>=0;i--) {
            for(int j=n-1;j>=0;j--) {
                if(matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i+1][j],Math.min(dp[i][j+1],dp[i+1][j+1])) + 1;
                    max = Math.max(max,dp[i][j]);
                }
            }
        }
        return max*max;
    }
}