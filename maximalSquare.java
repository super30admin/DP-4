// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * 1. Create a dp array of size m+1 and n+1. 
 * 2. Iterrate over the matrix and if the value is 1, then find the min of up, left and leftDiag and add 1 to it.
 * 3. Keep track of the max value and return max*max.
 */


class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int max = 0;
        int[][] dp = new int[m+1][n+1];

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(matrix[i-1][j-1] == '1'){
                    int up = dp[i-1][j], left = dp[i][j-1], leftDiag = dp[i-1][j-1];
                    int min = Math.min(up, Math.min(left, leftDiag));
                    dp[i][j] = min + 1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }

        return max*max;
    }
}