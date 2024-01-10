/*
 * BF approach
 * 1. go through Matrix
 * 2. if we find elemenet = 1, we go to its diagonal, and we check all the upper and LHS value,to be 1 to amke a square, if we never find that return 
 * max as it was never updated, else just incremet the current
 * 
 * TC: O(mn)^2; SC: O(1) 
 */

class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;

        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = false;
                if (matrix[i][j] == '1') {
                    flag = true;
                    int diag = 1;

                    // check for the rows and cols starting from digonal element
                    while (i + diag < m && j + diag < n && flag) {
                        // check rows
                        // row = i+diag;
                        int c = j + diag;
                        for (int r = i + diag; r >= i; r--) {
                            if (matrix[r][c] == '0') {
                                flag = false;
                                break;
                            }

                        }

                        // check columns
                        int r = i + diag;
                        // col = j + curr ; we are usigng as c as it's already defined above!
                        for (int col = j + diag; col >= j; col--) {
                            if (matrix[r][col] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            diag++;
                        }
                    }

                    max = Math.max(max, diag);
                }
            }
        }
        return max * max;
    }
}

/*
 * Approach - take the min of left elements (upper, diagnal, left) and add 1.
 * if , dont do anything!
 * sc: O(mn)
 * TC: O(mn)
 */

class Solution {
    public int maximalSquare(char[][] matrix) {
        // base case
        if (matrix == null || matrix.length == 0)
            return 0;

        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;

        // DP matrix to store the maximum subarray at each step
        int[][] dp = new int[m + 1][n + 1];

        // going over Matrix
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {

                // perform operations, only if find values = 1
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    max = Math.max(max, dp[i][j]); // updated Max
                }
            }
        }
        return max * max;
    }
}

// let's do better wth just in one Row!
/*
 * carrying left value, as diagUp, and curr value as curr.
 * doing the same min operation on all three values
 * TC: O(mn)
 * sc:o(n)
 */
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;

        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int curr = 0;
        int diagUp = 0;

        int[] dp = new int[n + 1];

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                curr = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    // left value, and diagonal are same. and upper value is same as its place.
                    dp[j] = Math.min(dp[j - 1], Math.min(dp[j], diagUp)) + 1;
                    max = Math.max(max, dp[j]);
                } else // we encountered zero, so we assign 0.
                {
                    dp[j] = 0;
                }
                diagUp = curr; // so we carrying diagonal values for next iteration, else that will be changed.
            }
        }
        return max * max;
    }
}