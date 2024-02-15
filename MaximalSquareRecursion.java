/*
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O((m*n)^2)
* 
* Space Complexity: O(1)
* 
*/

class MaximalSquareRecursion {
    int maxSquareSize = 0;

    private void getMaxSquareSize(char[][] matrix, int row, int col, int m, int n) {
        int i = row, j = col;

        int squareSize = 1;

        while (i < m && j < n) {
            if (i + 1 == m || j + 1 == n || matrix[i + 1][j + 1] != '1') {
                return;
            }

            // row check
            for (int index = j + 1; index >= col; index--) {
                if (matrix[i + 1][index] != '1')
                    return;
            }

            // col check
            for (int index = i + 1; index >= row; index--) {
                if (matrix[index][j + 1] != '1')
                    return;
            }

            squareSize++;
            i++;
            j++;
            maxSquareSize = Math.max(maxSquareSize, squareSize);
        }
    }

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;

        int n = matrix[0].length;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] == '1') {
                    maxSquareSize = Math.max(maxSquareSize, 1);
                    getMaxSquareSize(matrix, row, col, m, n);
                }
            }
        }

        return maxSquareSize * maxSquareSize;
    }
}