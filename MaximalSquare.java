// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// class Solution {
//     public int maximalSquare(char[][] matrix) {
//         int rows = matrix.length;
//         if (rows == 0)
//             return 0;
//         int cols = matrix[0].length;
//         int[][] dp = new int[rows + 1][cols + 1];
//         int max = 0;
//         for (int i = 1; i <= rows; i++) {
//             for (int j = 1; j <= cols; j++) {
//                 if (matrix[i - 1][j - 1] == '1') {
//                     dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
//                     max = Math.max(max, dp[i][j]);
//                 }
//             }
//         }
//         return max * max;
//     }
// }

// Time Complexity : O(mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        if (rows == 0)
            return 0;
        int curlen = 0;
        int cols = matrix[0].length;
        boolean flag = false;
        int maxLen = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    curlen = 1;
                    flag = true;
                    while (i + curlen < rows && j + curlen < cols && flag) {
                        // [i+curlen] [j+curlen]
                        for (int k = i; k <= i + curlen; k++) {
                            if (matrix[k][j + curlen] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        for (int k = j; k <= j + curlen; k++) {
                            if (matrix[i + curlen][k] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        if (flag)
                            curlen++;
                    }
                    maxLen = Math.max(maxLen, curlen);
                }
            }
        }
        return maxLen * maxLen;
    }
}