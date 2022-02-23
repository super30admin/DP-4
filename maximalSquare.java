package DataStructure.DynamicProgramming;

// Time Complexity : Add : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class MaximalSquare_BottomUp {
    public static void main(String[] args) {
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        maximalSquare(matrix);
    }

    public static int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return 0;

        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;

        int[][] dp = new int[m+1][n+1];

        for(int i=1;i<m+1;i++){ // T.C - o(m*n) ; S.C - O(m*n)
            for(int j=1; j<n+1; j++){
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(dp[i-1][j-1] , Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }

        return max*max;
    }
}

