class MaximalSquare {

    // Time: O(m^2 * n^2)
    // Space: O(1)
    // Approach: See diagonal element first and check the boundaries.
    // As long as they are all 1s, increment the result variable and carry on.
    public int maximalSquareBruteForce(char[][] matrix) {
        int res = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    int count = 1;
                    int l = 1;
                    boolean flag = true;
                    while (flag && i + l < matrix.length && j + l < matrix[0].length) {
                        if (matrix[i + l][j + l] == '0') {
                            // diagonal is not 1
                            break;
                        }

                        // columns compare
                        for (int x = j + l; x >= j; x--) {
                            if (matrix[i + l][x] == '0') {
                                flag = false;
                                break;
                            }
                        }

                        // rows compare
                        if (flag) {
                            // only if flag is still true
                            for (int x = i + l; x >= i; x--) {
                                if (matrix[x][j + l] == '0') {
                                    flag = false;
                                    break;
                                }
                            }
                        }

                        // only add if flag is still true
                        if (flag) {
                            count++;
                            l++;
                        }
                    }
                    res = Math.max(res, count);
                }
            }
        }
        return res * res;
    }

    // optimal solution
    // Time: O(m * n)
    // Space: O(m * n)
    // Approach: Using bottom up dp to find possible squares.
    // At any point the number of squares depend on left, diag up and up element

    public int maximalSquare(char[][] matrix) {
        int res = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        // first column as their value; as they are on the edge; they can either have 1
        // square or 0
        for (int i = 0; i < matrix.length; i++) {
            dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
            res = Math.max(dp[i][0], res);
        }

        for (int i = 0; i < matrix[0].length; i++) {
            dp[0][i] = matrix[0][i] == '1' ? 1 : 0;
            res = Math.max(dp[0][i], res);
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
                    res = Math.max(res, dp[i][j]);
                }
            }
        }

        return res * res;
    }

}