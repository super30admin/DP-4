// Time Complexity : O(n*m)
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class maximalSquareMatrix {
    int max = 0;
    int[][] left, up;

    private void checkSquare(char[][] matrix, int r, int c) {
        if (r - 1 >= 0 && c - 1 >= 0) {
            if (matrix[r-1][c] > '0' || up[r-1][c] > '0')
                up[r][c] = up[r-1][c] + 1;
            if (matrix[r][c-1] > '0' || left[r][c-1] > '0')
                left[r][c] = left[r][c-1] + 1;

            // now check for biggest possible square at [r][c]
            if (matrix[r-1][c-1] >= '1' && matrix[r][c-1] >= '1' && matrix[r-1][c] >= '1') {
                int min = Math.min(up[r][c], left[r][c]);
                min = Math.min(min, (matrix[r-1][c-1] - '0'));
                matrix[r][c] = (char)(min + 1 + '0');
                max = Math.max(max, min+1);
            }
        }
    }

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        left = new int[m][n];
        up = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] >= '1') {
                    if (max == 0) // this is the first 1
                        max = 1;
                    else
                        checkSquare(matrix, i, j); // check for square at matrix[i][j]
                }
            }
        }

        return max * max;
    }
}
