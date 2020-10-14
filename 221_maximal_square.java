  
    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/maximal-square/
    Time Complexity for operators : o(n*m) .. matrix size n*m
    Extra Space Complexity for operators : o(n*m)
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : Two for loops and find the minimum window that has string. o(n*2) time complexity
        # Optimized approach: 
                              
            # 1. 
                    A) Do it using DP. Two for loop for iteration. We will apply DP only if we have character 1 found.
                    B) We will create the matrix of dp[n+1][m+1]. The first row and column in this wikll be Zero.
                    C) Now calcualte values for 1. we will select min of left(i-1,j), above(i,j-1) and diagonal(i-1,j-1) then
                       Add one to it and store it into DP matrix/
                    D) If it is greater than max then change value of max.
                    E) At the end, return max * max.
    */

class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        
        int n = matrix.length;
        int m = matrix[0].length;
        int dp[][] = new int[n+1][m+1];
        int max = Integer.MIN_VALUE;
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j]  = Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
                    max = Math.max(max,dp[i][j]);
                }
            }
        }
        
        return max * max;
    }
}