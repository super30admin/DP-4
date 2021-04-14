class MaximalSquare {

    // Time Complexity: O(nm)   (where n -> no. of rows and m -> no. of columns)
    // Space Complexity: O(nm)

    public int maximalSquare(char[][] matrix) {
        int result = 0;
        // Edge Case Checking
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return result;
        
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                // If it is the first row or column - store the value as it is
                if(i == 0 || j == 0){
                    dp[i][j] = matrix[i][j] - '0';
                    result = Math.max(result, dp[i][j]);
                }else{
                    // If the value is 1 -> then it is a square in itself and all the three squares - up,left,diagnoal should be 1 
                    if(matrix[i][j] == '1'){
                        dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1]));
                        result = Math.max(result, dp[i][j]);
                    }
                }
            }
        }
        // return area of the largest square
        return result*result;
    }
}