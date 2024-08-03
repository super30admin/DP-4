class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return 0;
        }
        // Brute force
        // int m = matrix.length;
        // int n = matrix[0].length;
        // int max = 0;
        // for(int i = 0; i < m; i++) {
        //     for(int j = 0; j < n; j++) {
        //         if(matrix[i][j] == '1') {
        //             int curr = 1;
        //             boolean flag = true;
        //             while(i + curr < m && j + curr < n && flag == true) {
        //                 // check all rows for same column
        //                 for(int k = i + curr; k >= i; k--) {
        //                     if(matrix[k][j + curr] != '1') {
        //                         flag = false;
        //                         break;
        //                     }
        //                 }
        //                 // check all the columns for the same rows
        //                 for(int k = j + curr; k >= j; k--) {
        //                     if(matrix[i + curr][k] != '1') {
        //                         flag = false;
        //                         break;
        //                     }
        //                 }
        //                 if(flag == true) {
        //                     curr++;
        //                 }
        //             }
        //             max = Math.max(max, curr);
        //         }
        //     }
        // }
        // return max * max;

        // DP with 2D array
        // int m = matrix.length;
        // int n = matrix[0].length;
        // int [][] dp = new int[m + 1][n + 1];
        // int max = 0;
        // for(int i = 1; i < m + 1; i++) {
        //     for(int j = 1; j < n + 1; j++) {
        //         if(matrix[i - 1][j - 1] == '1') {
        //             dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
        //             max = Math.max(max, dp[i][j]);
        //         }
        //     }
        // }
        // return max * max;

        // DP with 1D array
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int [] dp = new int[n + 1];
        for(int i = 1; i < m + 1; i++) {
            int temp = dp[0];
            for(int j = 1; j < n + 1; j++) {
                int prev = dp[j];
                if(matrix[i - 1][j - 1] == '1') {
                    dp[j] = 1 + Math.min(dp[j - 1], Math.min(dp[j], temp));
                    max = Math.max(max, dp[j]);
                } else {
                    dp[j] = 0;
                }
                temp = prev;
            }
        }
        return max * max;

    }
}
