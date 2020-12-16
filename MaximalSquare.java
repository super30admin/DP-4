//Memoization

public int maximalSquare(char[][] matrix) {
    if (matrix.length == 0) return 0;

    int m = matrix.length, n = matrix[0].length, maxLength = 0;
    int[][] memo = new int[m][n];

    for (int r = 0; r < m; r++) {
        for (int c = 0; c < n; c++) {
            maxLength = Math.max(maxLength, getMaxLength(r, c, matrix, memo));
        }
    }

    return maxLength * maxLength;
}

private int getMaxLength(int r, int c, char[][] matrix, int[][] memo) {
    if (r < 0 || r >= matrix.length || c < 0 || c >= matrix[r].length || matrix[r][c] == '0') return 0;
    if (memo[r][c] != 0) return memo[r][c];

    return memo[r][c] = Math.min(
        getMaxLength(r + 1, c + 1, matrix, memo),
        Math.min(getMaxLength(r, c + 1, matrix, memo), getMaxLength(r + 1, c, matrix, memo))
    ) + 1;
}

//Recursion

// public int maximalSquare(char[][] matrix) {
//     int maxLength = 0;

//     for (int r = 0; r < matrix.length; r++) {
//         for (int c = 0; c < matrix[r].length; c++) {
//             maxLength = Math.max(maxLength, getMaxLength(r, c, matrix));
//         }
//     }

//     return maxLength * maxLength;
// }

// private int getMaxLength(int r, int c, char[][] matrix) {
//     if (r < 0 || r >= matrix.length || c < 0 || c >= matrix[r].length || matrix[r][c] == '0') return 0;

//     return Math.min(
//         getMaxLength(r + 1, c + 1, matrix),
//         Math.min(getMaxLength(r, c + 1, matrix), getMaxLength(r + 1, c, matrix))
//     ) + 1;
// }

//DP

public int maximalSquare(char[][] matrix) {
    int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
    int[][] dp = new int[rows + 1][cols + 1];
    int maxsqlen = 0;
    for (int i = 1; i <= rows; i++) {
        for (int j = 1; j <= cols; j++) {
            if (matrix[i-1][j-1] == '1'){
                dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                maxsqlen = Math.max(maxsqlen, dp[i][j]);
            }
        }
    }
    return maxsqlen * maxsqlen;
}
}