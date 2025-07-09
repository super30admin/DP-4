class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int r = matrix.length;
        int c = matrix[0].length;
        int[][] dp = new int[r][c];
        int maxsidelen = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {

                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        // Find the size of the square ending at this cell
                        dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    }
                    // Update the maximum side length found so far
                    maxsidelen = Math.max(maxsidelen, dp[i][j]);
                }
            }
        }

        return maxsidelen * maxsidelen;
    }
}

//
import java.util.*;

public class solution {
    // Function to solve LeetCode 1043
    public static int maxSumAfterPartitioning(int[] A, int K) {
        int n = A.length;
        int[] dp = new int[n + 1]; // dp[i]: max sum for first i elements
        for (int i = 1; i <= n; i++) {
            int maxVal = 0;
            for (int k = 1; k <= K && i - k >= 0; k++) {
                maxVal = Math.max(maxVal, A[i - k]);
                dp[i] = Math.max(dp[i], dp[i - k] + maxVal * k);
            }
        }
        return dp[n];
    }