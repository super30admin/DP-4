class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        int[][] dp = new int[row+1][col+1];
        int max = 0;
        
        for(int i = 1; i <= row; i++){
            for(int j = 1; j <= col; j++){
                if(matrix[i-1][j-1] == '1'){
                    //check the previous corresponding three elements and find minimum of them and 1 to it.
                    dp[i][j] = 1 + Math.min(dp[i-1][j],Math.min(dp[i-1][j-1], dp[i][j-1])); 
                    max = Math.max(dp[i][j], max);//to keep track of max value
                }
            }
        }
        
        return max*max;
    }
}
// Time Complexity: O(n*m)
// Space Complexity: O(n*m)