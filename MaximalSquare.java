class Solution {
    
    /*
    
    Thought Process: Brute force approach goes (mn)square. So we need to optimize the T.C. By checking the curr elements left, top and left-top elements. It will be the min of them plus 1. 
    
    T.C - O(MN) - Rows and Cols
    S.C - O(MN) - To store the DP array
    
    */
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0 || matrix == null) return 0;
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int[][] dp = new int[rows+1][cols+1];
        
        int maxSqrLen = 0;
        
        for(int i=1; i <= rows; i++){
            for(int j=1; j <= cols; j++){
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    maxSqrLen = Math.max(maxSqrLen, dp[i][j]);
                }
            }
        }
        return maxSqrLen * maxSqrLen;
    }
}