
//tc is O(mxn)
//sc is O(mxn)
import java.util.*;

class Solution {
    public int maximalSquare(char[][] matrix) {

        if (matrix == null || matrix.length == 0)
            return 0;

        int m = matrix.length;
        int n = matrix[0].length;
        int dp[][] = new int[n + 1];
        int max = 0;

        // we iterate from 1x1

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }

        return max * max;

    }
}