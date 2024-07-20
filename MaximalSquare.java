/***
 Approach 3 - 1D DP Bottom up
 TC = O(m*n)
 SC = O(m*n)
 */
class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return 0;

        int max =0;

        int m = matrix.length;
        int n = matrix[0].length;

        int[] dp = new int[n+1];

        //check for cell having value '1'
        for(int i =1; i <= m; i++) {
            int temp = dp[0];
            for(int j =1; j <= n; j++) {
                int prev = dp[j];
                if(matrix[i-1][j-1] == '1') {
                    //Take min of dp[i-1], dp[i], and temp and add '1' to it
                    dp[j] = Math.min(dp[j-1], Math.min(dp[j], temp)) + 1;
                    max = Math.max(max, dp[j]);
                }

                else
                    dp[j] = 0;

                temp = prev;
            }
        }

        return max * max;

    }
}