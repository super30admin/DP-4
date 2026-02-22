//Solution 1: DP with 2D array
// TC - O(m*n) - iterate over matrix once.
// SC - O(m*n) - DP array space.
// class Solution {
//     public int maximalSquare(char[][] matrix) {
//         int m = matrix.length;
//         int n = matrix[0].length;
//         int[][] dp = new int[m][n];
//         int max = 0;

//         for(int i=m-1; i>=0; i--) {
//             for (int j = n-1; j>=0;j--){
//                 // System.out.print(matrix[i][j]);
//                 if(matrix[i][j] == '1') {

//                     if(i== m-1 || j == n-1) {
//                         dp[i][j] = matrix[i][j] - '0';
//                     } else {
//                         dp[i][j] = Math.min(Math.min(dp[i][j+1], dp[i+1][j]), dp[i+1][j+1]) + 1;

//                     }
//                     max = Math.max(dp[i][j], max);

//                 }
//             }
//             // System.out.println("");
//         }

//         return max*max;

//     }
// }

// Solution 2: DP with 1D array
// TC - O(m*n) - iterate over matrix once.
// SC - O(n) - DP array space.
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[] dp = new int[n];
        for (int i = m - 1; i >= 0; i--) { // iterate over matrix from bottom right corner to top left corner.
            int diagnalDown = 0;
            for (int j = n - 1; j >= 0; j--) { // iterate over matrix from bottom right corner to top left corner.
                int temp = dp[j];
                if (matrix[i][j] == '1') { // if current cell is 1 then calculate dp value for current cell.
                    if (i == m - 1 || j == n - 1) { // if current cell is in last row or last column then dp value is 1.
                        dp[j] = matrix[i][j] - '0';
                    } else { // if current cell is not in last row or last column then dp value is minimum of
                             // right, down and diagonal down + 1.
                        dp[j] = Math.min(Math.min(dp[j + 1], dp[j]), diagnalDown) + 1;
                    }
                    max = Math.max(dp[j], max); // update max value with current dp value.
                } else {
                    dp[j] = 0; // if current cell is 0 then dp value is 0.
                }
                diagnalDown = temp; // update diagonal down value with current dp value before updating current dp
                                    // value. This is because we need to use current dp value for next iteration of
                                    // inner loop.
            }
        }
        return max * max; // return max value which is area of largest square.
    }
}