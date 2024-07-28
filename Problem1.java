/*
    LC - 221. Maximal Square
    TC - O(m * n)
    SC - O((n)
    Approach -
        Traverse through the matrix, store the temp = dp[0]
        take the prev and check if matrix value is 1, then check the left, top, diagonal(which is temp)
        keep track of max with the dp

        else update dp to zero (as we are maintaining only 1D dp)
        update the temp with prev;

        return max * max;
*/

class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] dp = new int[n+1];
        int max = 0;
        for(int i = 1; i< m+1; i++) {
            int temp = dp[0];
            for(int j=1; j<n+1; j++) {
                int prev = dp[j];
                if(matrix[i-1][j-1] == '1') {
                    dp[j] = 1+ Math.min(dp[j - 1], Math.min(dp[j], temp));
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

/*
    TC - O(m * n)
    SC - O(m * n)
    Approach -
        Traverse through the matrix, check if value is 1
        if it is 1, then store it in DP, check the top, left, prev diagonal
        Keep track of max with dp

        return max * max
*/


class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        int max = 0;
        for(int i= 1; i<m+1; i++) {
            for(int j=1; j<n+1; j++) {
                if(matrix[i-1][j-1] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
}