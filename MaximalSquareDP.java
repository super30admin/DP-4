package Dec7;

class MaximalSquareDP {
    public int maximalSquare(char[][] matrix) {
        
        /*
        Time complexity: O(m*n) because traversing through each element of the given matrix once
        Space complexity: O(m*n) because using extra space in dp array of size m*n 
        
        Approach: DP
        */
        
        // edge
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        
        int m = matrix.length, n = matrix[0].length;
        int max = 0;
        int[][] dp = new int[m+1][n+1];
        
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                // note that matrix[i-1][j-1] corresponds to dp[i][j] because dp array contains one extra row and one extra columns as compared to matrix and we are starting i and j loops from 1.
                if (matrix[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                    max = Math.max(max,dp[i][j]);
                }
            }
        }    
        
        return max*max;       
    } 
}