// TC: O(mn)
// SC: O(n) => n is the number of columns

// 1: We maintain a 1D DP array that holds the value of the maximal square thus formed by the elements below it
// 2: We move right to left and have a separate variable for the diagonalDown value at each row so that we avoid going out of bounds. This value is updated once we have a true diagonal down value.
// 3: The maximum is tracked through a variable that updates whenever we come across a larger edge of the square that can be formed
class Solution {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int max = 0;
        int[] dp = new int[cols + 1];

        // starting from bottom
        for (int i = rows - 1; i >= 0; i--) {
            int diagonalDown = 0;
            for (int j = cols - 1; j >= 0; j--) {
                int temp = dp[j];
                if (matrix[i][j] == '1') {
                    // look at three directions
                    int right = dp[j + 1];
                    int down = dp[j];
                    dp[j] = 1 + Math.min(right, Math.min(diagonalDown, down));
                    max = Math.max(max, dp[j]);
                } else {
                    dp[j] = 0;
                }
                diagonalDown = temp;
            }
        }
        return max * max;
    }
}