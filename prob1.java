// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes


class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length, min = Math.min(m, n);
        int[][] arrH = new int[m][n];
        for (int r = 0; r < m; r++) {
            int count = 0;
            for (int c = 0; c < n; c++) {
                if (matrix[r][c] == '1') arrH[r][c] = ++count;
                else count = 0;
            }
        }

        int[][] arrV = new int[m][n];
        for (int c = 0; c < n; c++) {
            int count = 0;
            for (int r = 0; r < m; r++) {
                if (matrix[r][c] == '1') arrV[r][c] = ++count;
                else count = 0;
            }
        }

        int max = 0;
        for (int c = 0; c < n; c++) {
            for (int r = 0; r < m; r++) {
                int minC = Math.min(arrH[r][c], arrV[r][c]);
                if (max < minC) {
                    while (minC > max) {
                        if (noZeros(r,c,matrix,minC)) {
                            max = minC;
                            break;
                        }
                        minC--;
                    }
                }
            }
        }
        return max * max;
    }

    private boolean noZeros(int row, int col, char[][] matrix, int minC) {
        for (int r = row - minC + 1; r < row; r++) {
            for (int c = col - minC + 1; c < col; c++) {
                if (matrix[r][c] == '0') return false;
            }
        }
        return true;
    }
}