// Time Complexity : O(m * n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
We see repeated subproblems in this problem, so we optimize using DP.For each cell starting from top of the matrix,
we calculate the cell by taking minimum of its neighbours(top,left, diagonal up) and add one to it to form a square.
Then, we keep track of maximum value at every iteration and lastly return product of max itself.In this dp, we
use a 1D array and for diagonal up value storage, we use temp variable to track it and update it every time.
 */
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] dp = new int[n + 1];
        int max = 0;
        int diagUp = 0;

        for(int i = 1 ; i <= m ; i++) {
            for(int j = 1 ; j <= n ; j++) {
                int temp = dp[j];
                if(matrix[i - 1][j - 1] == '1') {
                    dp[j] = 1 + Math.min(dp[j] , Math.min(dp[j - 1], diagUp));
                    max = Math.max(max, dp[j]);
                }
                else {
                    dp[j] = 0;
                }
                diagUp = temp;
            }
        }
        return max * max;
    }
}