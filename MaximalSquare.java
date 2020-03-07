// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        int max = 0;
        
        for(int i = 0; i < row; i++){
            dp[i][0] = matrix[i][0] - '0';
            max = Math.max(max, dp[i][0]);
        }
        
        for(int i = 0; i < col; i++){
            dp[0][i] = matrix[0][i] - '0';
            max = Math.max(max, dp[0][i]);
        }
        
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(matrix[i][j] == '1'){
                    dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j-1], dp[i-1][j])) + 1;
                    max = Math.max(max, dp[i][j]);
                    System.out.println(dp[i][j]);
                }
            }
        }
        
        return max*max;
    }
}

//Brute Force

// Time Complexity : O(M^2 x N^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        
        
        if(row == 0 || matrix == null){
            return 0;
        }
        
        int col = matrix[0].length;
        int max = 0;
        boolean flag = false;
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(matrix[i][j] == '1'){
                    flag = true;
                    int curr = 1;
                    while(i+curr < row && j + curr < col && flag){
                        for(int k = j + curr; k >= j; k--){
                            if(matrix[i+curr][k] == '0'){
                                flag = false;
                                break;
                            }
                        }
                        
                        for(int k = i + curr; k >= i; k--){
                            if(matrix[k][j + curr] == '0'){
                                flag = false;
                                break;
                            }
                        }
                        
                        if(flag)curr++;
                        
                    }
                    
                    max = Math.max(max,curr);
                }
            }
        }
        return max*max;
    }
}