// In this problem, trying to traverse diagonally within the bound of m and n, if the cell value is 1, checking above and left 
// if all cells are 1 within the bound of current cell which is [i][j], then increment current. Like that it will check for all
// occurences of '1' i.e. all possible squares, so compare max and curr and update max. This is why we get time limit exceeded error

// Time Complexity : O(m*n)^2
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Bruteforce solution
class Solution {
    public int maximalSquare(char[][] matrix) {
        // Base case
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        // Max variable
        int max = 0;
        // Iterate through the matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Check if the current cell value is 1
                if (matrix[i][j] == '1') {
                    // Declare a curr variable to compute the diagonal length, indirectly to compute
                    // area of sqr
                    int curr = 1;
                    // Declare a boolean flag and set it to true
                    boolean flag = true;
                    // Now from the current cell move diagonally(i+curr,j+curr) and check all cell
                    // values i.e. above and left of that square
                    while (i + curr < m && j + curr < n && flag == true) {
                        // For checking above values, start from the diagonal value, go until i
                        for (int k = i + curr; k >= i; k--) {
                            // Check if in between any cell value is not 1 than set the flag as false and
                            // break
                            if (matrix[k][j + curr] != '1') {
                                flag = false;
                                break;
                            }
                        }
                        // For checking left values, start from the diagonal value, go until j
                        for (int k = j + curr; k >= j; k--) {
                            // Check if in between any cell value is not 1 than set the flag as false and
                            // break
                            if (matrix[i + curr][k] != '1') {
                                flag = false;
                                break;
                            }
                        }
                        // After that check if flag value is true, increment the curr to move to the
                        // next diagonal value
                        if (flag == true) {
                            curr++;
                        }
                    }
                    // Compare max with curr and update max
                    max = Math.max(max, curr);
                }

            }
        }
        // For area return max*max
        return max * max;
    }
}

// Dp table solution
// In this approach, creating a dp table of m*n which stores maximal square
// value for each cell. So, it is given by min of top,left and diagonal value
// and add to it 1. Update max accordingly
// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public int maximalSquare(char[][] matrix) {
        // Base case
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        // Dp table of 1 size more for dummy row and dummy col for first row and first
        // col
        int[][] dp = new int[m + 1][n + 1];
        // Declare max
        int max = 0;
        // Iterate through the matrix and create dp table and max value of that table
        // will be stored in max
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                // Check if cell is 1
                if (matrix[i - 1][j - 1] == '1') {
                    // dp cell value will be min of left, top and diagonal + 1
                    dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
                    // Update max
                    max = Math.max(max, dp[i][j]);
                }

            }
        }
        // Return max * max
        return max * max;
    }
}

// Dp row solution
// In this approach, at any point we are just comparing with 3 values i.e. top,
// left and diagonal. So why to create whole table, we can just keep a row.
// Creating a dp row of n+1 which stores maximal square value for each cell of
// that row.

// Time Complexity : O(m*n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public int maximalSquare(char[][] matrix) {
        // Base case
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        // Dp row
        int[] dp = new int[n + 1];
        int max = 0;
        // Iterate through the matrix, create the dp row one by one, store max of row in
        // max
        for (int i = 0; i < m; i++) {
            // Temp for the diagonal value
            int temp = dp[0];
            // Create each row
            for (int j = 1; j < n + 1; j++) {
                // Store the current value
                int prev = dp[j];
                // If the char is 1
                if (matrix[i][j - 1] == '1') {
                    // Take the min of left, top, and diagonal and add 1
                    dp[j] = Math.min(dp[j - 1], Math.min(dp[j], temp)) + 1;
                    // Update max
                    max = Math.max(max, dp[j]);
                } else {
                    // If char is 0 then 0
                    dp[j] = 0;
                }
                // Give value in prev to temp
                temp = prev;
            }
        }
        // Return area
        return max * max;
    }
}