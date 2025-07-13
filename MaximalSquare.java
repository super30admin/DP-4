// TC : O(M*N) -- Iterate over the matrix once
// SC : O(M*N) -- Creating a array of size(dp) m*n

// Approach:
// First when 1 is encountred in the matrix we start calculating or else it zero by default.
// for every one encountered we check the diagonal, top, left to compute the current value.
// Take the min of 3 and add 1 to it.
// for every one encountered calculate the  max square that can be formed.

class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        if(m == 0 || n == 0) return 0;
        int [][]dp = new int[m+1][n+1];
        int max = 0;
        for(int i = 1; i<= m; ++i){
            for(int j = 1; j <= n; ++j){
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(dp[i-1][j] , Math.min(dp[i][j-1], dp[i-1][j-1]))+1;
                    max = Math.max(max,dp[i][j]);
                }
            }
        }
        return max*max;
    }
}
