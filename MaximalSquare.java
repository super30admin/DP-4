// Approach : Brute Force Approach - to go over diagonal with boundaries
// Time : O(m^2*n^2)
// Space : O(1)
class Solution {
    public int maximalSquare(char[][] matrix) {
        // edge case
        if (matrix == null || matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        boolean flag = false; // To identify if you have zero
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    int curr = 1; // 1x1 matrix at (i,j)
                    flag = true;
                    // traverse diagonally with boundary conditions
                    while (i + curr < m && j + curr < n && flag) {
                        // check for all cols has '1' from the reached diagonal untill boundary (up)
                        // iterate over rows
                        for (int k = i + curr; k >= i; k--) {
                            if (matrix[k][j + curr] == '0') {
                                flag = false;
                                break;
                            }
                        }

                        // check for all rows has '1' from the reached diagonal untill boundary (left)
                        // iterate over cols
                        for (int k = j + curr; k >= j; k--) {
                            if (matrix[i + curr][k] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        // keep increasing the square
                        if (flag) {
                            curr++;
                        }
                    }
                    max = Math.max(max, curr);// length of the square
                }
            }
        }

        return max * max; // area of largest sqaure
    }
}




// Approach : DP with memoization -
// Time : O(m*n)
// Space : O(m*n)
class Solution {
    public int maximalSquare(char[][] matrix) {
        // edge case
        if (matrix == null || matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[][] dp = new int[m+1][n+1];
        for(int i =1;i<dp.length;i++){
            for(int j = 1;j<dp[0].length;j++){
                // have added additional row at the top
                if(matrix[i-1][j-1]=='1'){
                    dp[i][j] = 1+ Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));
                    max = Math.max(max,dp[i][j]);
                } 
            }
        }
        return max * max; // area of largest sqaure
    }
}