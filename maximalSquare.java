// Time Complexity = O(mn)
// Space Complexity = O(mn)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// This is a DP problem
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int maxSoFar = 0;
        int m=matrix.length;
        int n=matrix[0].length;

        // Create a dp array to store the square size at each point
        int[][] dp = new int[m+1][n+1];

        // traverse the matrix and find the largest square at each point
        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                // check if value in matrix at i-1, j-1 is 1, only then update the value otherwise its 0 by default
                if (matrix[i-1][j-1] == '1') {
                    // the element at the current position will be calculated as the min of the (left, top, and diagonal element) + 1
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]))+1;

                    // check if the element is max so far
                    maxSoFar = Math.max(maxSoFar, dp[i][j]);
                }
            }
        }

        // Return square of maxSoFar since we want the area of the square
        return maxSoFar*maxSoFar;
    }
}