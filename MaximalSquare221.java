class Solution {
    // Approach: DP
    //      1 + Min( left, top, and diagonal--[i-1][j-1])
    //              1  for current 1, 
    //              Min value among three directions already traversed
    
    // Dp array -   i and j should start from 1 and not 0
    // First row and col are taken as 0 in dp array for evaluation purposes
    
    // Time Complexity: O(m*n)
    // Space Complexity: O(m*n)
    
    public int maximalSquare(char[][] matrix) {
        // Base condition
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        
        int r = matrix.length, c = matrix[0].length;
        
        int[][] dp = new int[r+1][c+1];
        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= r; i++){
            for(int j = 1; j <= c; j++){
                
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1]));
                    max = Math.max (max, dp[i][j]);
                } else
                    dp[i][j] = 0;       // if   matrix[i-1][j-1] is 0 ==> 0
            }
        }
        return max * max;       // area
    }
}