// Time: O(mn)
// Time : O(mn)


class Solution {
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0 ; i <m ; i++){
            for(int j = 0 ; j< n ; j++){
                dp[i][j] = Character.getNumericValue(matrix[i][j]);
            }
        }

        for(int i = 0 ; i <m ; i++){
            for(int j = 0 ; j< n ; j++){
                if(i>0 && j>0 && dp[i][j]>0){
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1])) +1;
                }
                 max = Math.max(max, dp[i][j]);   
            }
        }
        return max * max;
    }
}