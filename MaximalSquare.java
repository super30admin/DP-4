/**
 * Time Complexity: O(m*n)
 * Space Complexity: O(n)
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None

 * Approach:
 * There are repeated subproblems, so use the DP array.
 */

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;

        int[] dp = new int[n+1];
        int max = 0;
        for(int i = 0; i < m; i++) {
            // used to calculate value of dp[j] for the current row because dp is updated in place.
            int temp = dp[0];
            for (int j = 1; j < n + 1; j++) {
                int prev = dp[j];
                if (matrix[i][j - 1] == '1') {
                    dp[j] = Math.min(dp[j - 1], Math.min(dp[j], temp)) + 1;
                    max = Math.max(max, dp[j]);
                } else {
                    dp[j] = 0;
                }
                temp = prev;
            } 
        }

        return max * max;
    }
    public static void main(String[] args) {
        // Your code here
    }
}