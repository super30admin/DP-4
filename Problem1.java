// Time Complexity : O(N^N)
// Space Complexity : O(N^N)
// Did this code successfully run on Leetcode : Yes, 4ms
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//Calculate the minimum of the current dp[element], and all the adjacent cells  and maximum of the cells

class Solution {
    public int maximalSquare(char[][] matrix) {
        
        if(matrix.length == 0 || matrix == null){
            return 0;
        }
        
        int max = 0;
        
        int rows = matrix.length;
        
        int cols = matrix[0].length;
        
        int dp[][] = new int[rows+1][cols+1];
        
        for(int i = 1; i <= rows ; i++){
            for(int j = 1; j <= cols ; j++){
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j],dp[i][j-1])) + 1; // starting with 1
                
                    max = Math.max(max, dp[i][j]);
                }
            }
            
        }
        
        return max*max;
        
    }
}

