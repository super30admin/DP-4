// Time complexity - O(m*n)
// space complexity - O(m*n)
// solved on leetcode - yes
// Faced any issue - No
// using bottom up approach storing the number of squares can be formed in a dp matrix.
class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length,m = matrix[0].length;
        int max =0;
        int dp[][] = new int[n+1][m+1];
        for(int i=n-1;i>=0;i--) {
            for(int j=m-1;j>=0;j--) {
                if(matrix[i][j] == '1') {
                dp[i][j] = 1 + Math.min(Math.min(dp[i+1][j], dp[i][j+1]), dp[i+1][j+1]);
                max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max*max;
    }
}
