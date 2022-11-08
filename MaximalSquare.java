// Time Complexity : O(m*n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
    public int maximalSquare(char[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;

        int[] dp = new int[n+1];
        int temp = 0, diagUp = 0;
        for(int i = 1; i<m+1; i++) {
            for(int j = 1; j<n+1; j++) {
                //temp = dp[j];
                if(matrix[i-1][j-1] == '1') {
                    temp = dp[j];
                    dp[j] = Math.min(dp[j-1],Math.min(dp[j], diagUp)) + 1;
                    max = Math.max(max, dp[j]);
                } else {
                    dp[j] = 0;
                }
                diagUp = temp;
            }
        }
        return max*max;

        //DP matrix
        // int[][] dp = new int[m+1][n+1];

        // for(int i = 1; i<m+1; i++) {
        //     for(int j = 1; j<n+1; j++) {
        //         if(matrix[i-1][j-1] == '1') {
        //             dp[i][j] = Math.min(dp[i-1][j-1],(Math.min(dp[i][j-1], dp[i-1][j]))) + 1;
        //             max = Math.max(max, dp[i][j]);
        //         } else {
        //             dp[i][j] = 0;
        //         }
        //     }
        // }

        // return max*max;

        //Brute-Force
        // for(int i = 0; i<m; i++) {
        //     for(int j = 0; j<n; j++) {
        //         boolean flag;
        //         if(matrix[i][j] == '1') {
        //             int curr = 1;
        //             flag = true;
        //             while(i+curr <m && j+curr < n && flag) {
        //                 for(int k = i+curr; k>=i; k--) {
        //                     if(matrix[k][j+curr]=='0'){
        //                         flag = false;
        //                         break;
        //                     }
        //                 }
        //                 for(int k = j+curr; k>=j; k--) {
        //                     if(matrix[i+curr][k]=='0'){
        //                         flag = false;
        //                         break;
        //                     }
        //                 }
        //                 if(flag) {
        //                     curr++;
        //                 }
        //             }
        //             max = Math.max(max, curr);
        //         }
        //     }
        // }
        // return max*max;
    }
}