// https://leetcode.com/problems/maximal-square/

// Brute force: Top-down
// Time Complexity: O((m*n)^2)
// Space Complexity: O(1)

// DP: Bottom-up
// Time Complexity: O(m*n)
// Space Complexity: O(m*n)

class Solution {
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];

        for(int i = m-1; i >= 0; i--) {
            for(int j = n-1; j >= 0; j--) {
                if(matrix[i][j] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i][j+1], Math.min(dp[i+1][j], dp[i+1][j+1]));
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        // BRUTE FORCE
        // for(int i = 0; i < m; i++) {
        //     for(int j = 0; j < n; j++) {
        //         if(matrix[i][j] == '1') {
        //             int le = 1;
        //             boolean flag = true;
        //             while(i+le < m && j + le < n && flag)  {
        //                 //same column upto up wall
        //                 for(int k = i+le; k >= i; k--) {
        //                     if(matrix[k][j+le] == '0'){
        //                         flag = false;
        //                         break;
        //                     }
        //                 }

        //                 //same row upto left wall
        //                 for(int k = j+le; k >= j; k--) {
        //                     if(matrix[i+le][k] == '0'){
        //                         flag = false;
        //                         break;
        //                     }
        //                 }

        //                 if(flag) le++;
        //             }

        //             max = Math.max(max, le);

        //         }
        //     }
        // }

        return max*max;
    }
}