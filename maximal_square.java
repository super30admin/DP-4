// Time Complexity : O(m * n) because we process every cell in the matrix once
// Space Complexity : O(n) using 1D Dynamic Programming array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We use Dynamic Programming where dp[j] stores the side length of the largest square ending at the current cell.
// For every '1', the square size depends on the minimum among top, left, and top-left diagonal neighbors.
// We optimize space by using a 1D DP array and storing the previous diagonal value separately.

class Solution {

    public int maximalSquare(char[][] matrix) {

        int m = matrix.length;

        int n = matrix[0].length;

        // largest square side length
        int max = 0;

        // 1D DP array
        int[] dp = new int[n + 1];

        // previous diagonal value
        int diagUp = 0;

        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n; j++) {

                // store old top value
                int temp = dp[j];

                // cell contains 1
                if (matrix[i - 1][j - 1] == '1') {

                    // min of top, left and diagonal + 1
                    dp[j] =
                        1 +
                        Math.min(
                            dp[j],
                            Math.min(
                                dp[j - 1],
                                diagUp
                            )
                        );

                    // update maximum side length
                    max =
                        Math.max(
                            max,
                            dp[j]
                        );
                }

                // cell contains 0
                else {

                    dp[j] = 0;
                }

                // update diagonal for next cell
                diagUp = temp;
            }
        }

        // return maximum area
        return max * max;
    }
}