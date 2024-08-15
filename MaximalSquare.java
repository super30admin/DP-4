// Time Complexity : O(m*n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
class MaximalSquare {
    //TC = O(m*n)
    //SC = O(n)
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            int diagUp = 0;
            for (int j = 1; j <= n; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    int curr = 1 + Math.min(dp[j], Math.min(dp[j - 1], diagUp));
                    dp[j] = curr;
                    max = Math.max(max, curr);
                } else {
                    dp[j] = 0;
                }
                diagUp = temp;
            }
        }
        return max * max;
    }
}