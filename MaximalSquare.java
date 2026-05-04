// O(m * n) time, O(m) space
class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[] dp = new int[m+1];

        int max = 0;
        int diagUp = 0;

        // starting from 1,1 since extra row,col
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (matrix[i-1][j-1] == '1') {
                    int top = dp[j];
                    int left = dp[j-1];
                    int temp = dp[j];
                    dp[j] = 1 + Math.min(top, Math.min(left, diagUp));
                    diagUp = temp;
                    max = Math.max(max, dp[j]);
                }
                else {
                    dp[j] = 0;
                }
            }
        }

        return max * max; //area
    }
}