// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class MaximalSquare {
    class Solution {
        public int maximalSquare(char[][] matrix) {
            //try brute force
            int m = matrix.length, n = matrix[0].length;
            int result = 0;

            if(matrix == null || n == 0 && m == 0)
                return result;

            // for(int i = 0; i < m; i++){
            //     for(int j = 0; j < n; j++){
            //         if(matrix[i][j] == '1'){
            //             //go down diagonally
            //             int l = 1;
            //             boolean flag = true;
            //             while(flag && i+l < m && j+l < n){
            //                 //row check
            //                 for(int k = i+l; k >= i; k--){
            //                     if(matrix[k][j+l] != '1'){
            //                         flag = false;
            //                         break;
            //                     }
            //                 }
            //                 //col check
            //                 for(int k = j+l; k >= j; k--){
            //                     if(matrix[i+l][k] != '1'){
            //                         flag = false;
            //                         break;
            //                     }
            //                 }
            //                 if(flag)
            //                     l++;
            //             }
            //             result = Math.max(result, l);
            //         }
            //     }
            // }

            int [][]dp = new int[m+1][n+1];

            for(int i = 1; i <= m; i++){
                for(int j = 1; j <= n; j++){
                    if(matrix[i-1][j-1] == '1'){
                        dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1])) + 1;
                        result = Math.max(result, dp[i][j]);
                    }
                }
            }


            return result * result;
        }
    }
}
