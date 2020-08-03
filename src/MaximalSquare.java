// Time Complexity : DP O(m*n)
// Space Complexity :DP O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


/**
 * https://leetcode.com/problems/maximal-square/
 */


 //DP O(m*n) time and spacesolution
 public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        
        int m = matrix.length, n = matrix[0].length, max=0;
        
        int[][] dp = new int[m+1][n+1];
        
        for(int i=1; i<m+1;i++) {
            for (int j=1; j<n+1; j++) {
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = 1 + Math.min(dp[i-1][j], 
                                            Math.min(dp[i-1][j-1], dp[i][j-1]));
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        
        return max * max;
    }
 
//brute force (m*n)^2 time , O(1) space
public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        
        int m = matrix.length, n = matrix[0].length;
        int max = 0; boolean flag = false;
        
        for(int i =0; i< m; i++) {
            for (int j=0; j<n;j++) {
                
                if(matrix[i][j] == '1') {
                    flag = true; 
                    int curr = 1;
                    
                    while(i+curr < m && j+ curr < n && flag) {
                        
                        //column
                        for(int k = i+curr; k >= i; k--){
                            if(matrix[k][j+curr] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        
                        //row
                        for(int k = j+curr; k >= j; k--){
                            if(matrix[i+curr][k] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        if(flag) curr++;
                    }
                    max = Math.max(max, curr);
                }  
            }
        }
        
        return max*max;
    }