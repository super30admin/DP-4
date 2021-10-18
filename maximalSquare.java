// Time Complexity : O(m^2 * n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length ==0) return 0;
        int m = matrix.length; int n = matrix[0].length;
        int max = 0; boolean flag = false;
        
        for(int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                flag = false;
                if(matrix[i][j] == '1'){
                    flag = true;
                    int curr = 1;
                    // i + curr, j + curr
                    while(i+curr <m && j+curr <n && flag){
                        //row check
                        for(int k=i; k<=i+curr; k++){
                            if(matrix[k][j+curr] == '0'){
                                flag = false;
                                break;
                            }
                        }
                        //col check
                        for(int k=j; k<=j+curr; k++){
                            if(matrix[i+curr][k] == '0'){
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
}

// ****************************************

//Repeated sub-problem -> DP
// BF approach was top right, DP is bottom up
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length ==0) return 0;
        int m = matrix.length; int n = matrix[0].length;
        int max = 0; 
        int[][] dp = new int[m+1][n+1];
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = 1 + Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1]));
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
       
        return max*max;
    }
}

// ****************************************

// DP improved version
// O(1) space!

class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length ==0) return 0;
        int m = matrix.length; int n = matrix[0].length;
        int max = 0; 
        int prev = 0; int diagUp = 0;
        int[] dp = new int[n+1];
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                prev = dp[j];
                if(matrix[i-1][j-1] == '1'){
                    // dp[i][j] = 1 + Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1]));
                    dp[j] = 1 + Math.min(dp[j-1], Math.min(dp[j], diagUp));
                    max = Math.max(max, dp[j]);
                } else{
                    dp[j] = 0;
                }
                diagUp = prev;
            }
        }
        return max*max;
    }
}