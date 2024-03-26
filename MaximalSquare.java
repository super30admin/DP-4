class Solution {

    int max;

    public int maximalSquare(char[][] matrix) {
        max = 0;
        // helper(matrix, 0, 0);

        // int[][] dp = new int[matrix.length][matrix[0].length];
        // Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
        // helperMemo(matrix, 0, 0, dp);

        heleprTopDowm(matrix);
        return max * max;
    }

    private int helper(char[][] matrix, int r, int c) {
        if (r >= matrix.length || c >= matrix[0].length)
            return 0;

        int right = helper(matrix, r, c + 1);
        int diagonal = helper(matrix, r + 1, c + 1);
        int down = helper(matrix, r + 1, c);

        if (matrix[r][c] == '1') {
            int ans = Math.min(right, Math.min(diagonal, down)) + 1;
            max = Math.max(ans, max);
            return ans;
        } else
            return 0;
    }

    // Tc: O(m * n)
    // Sc: O(m * n)
    private int helperMemo(char[][] matrix, int r, int c, int[][] dp) {
        if (r >= matrix.length || c >= matrix[0].length)
            return 0;
        if (dp[r][c] != -1)
            return dp[r][c];

        int right = helperMemo(matrix, r, c + 1, dp);
        int diagonal = helperMemo(matrix, r + 1, c + 1, dp);
        int down = helperMemo(matrix, r + 1, c, dp);

        if (matrix[r][c] == '1') {
            dp[r][c] = Math.min(right, Math.min(diagonal, down)) + 1;
            max = Math.max(dp[r][c], max);
        } else {
            dp[r][c] = 0;
        }
        return dp[r][c];
    }

    // Tc: O(m * n)
    // Sc: O(m * n)
    private void heleprTopDowm(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row + 1][col + 1];
        Arrays.stream(dp).forEach(r -> Arrays.fill(r, 0));

        for (int r = row - 1; r >= 0; r--) {
            for (int c = col - 1; c >= 0; c--) {
                int right = dp[r][c + 1];
                int diagonal = dp[r + 1][c + 1];
                int down = dp[r + 1][c];

                if (matrix[r][c] == '1') {
                    dp[r][c] = Math.min(right, Math.min(diagonal, down)) + 1;
                    max = Math.max(dp[r][c], max);
                } else {
                    dp[r][c] = 0;
                }
            }
        }
    }
}