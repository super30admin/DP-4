//Time Complexity: O(m*n) where m is the number of rows and n is the number of columns in the matrix
// Space Complexity: O(m*n) for the dp array

/* Intuition - This code finds the largest square containing only 1's in a binary matrix and returns its area by 
 using dynamic programming. It iterates through the matrix in reverse order, updating a dp array that
 keeps track of the size of the largest square that can be formed at each position. The maximum square length
 found is then squared to get the area of the maximal square.
*/

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxSqLen = 0;
        int[][] dp = new int[m + 1][n + 1];
        // matrix can be traversed in reverse order as well from top left to bottom
        // right
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i + 1][j], dp[i + 1][j + 1]), dp[i][j + 1]);
                    maxSqLen = Math.max(dp[i][j], maxSqLen);
                }
            }
        }
        return maxSqLen * maxSqLen;
    }
}

// space optimization using 1-d array
// Time Complexity: O(m*n) where m is the number of rows and n is the number of
// columns in the matrix
// Space Complexity: O(n) for the dp array
class MaxSquare {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxSqLen = 0;
        int[] dp = new int[n + 1];
        int prevDiagDown = 0; // to store the value of dp[i+1][j+1] from the previous row
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int temp = dp[j]; // store current dp[j] before updating it
                if (matrix[i][j] == '1') {
                    dp[j] = 1 + Math.min(Math.min(dp[j], dp[j + 1]), prevDiagDown);
                    maxSqLen = Math.max(dp[j], maxSqLen);
                } else {
                    dp[j] = 0; // reset if it's '0'
                }
                prevDiagDown = temp; // update prev for the next iteration
            }
        }
        return maxSqLen * maxSqLen;
    }
}