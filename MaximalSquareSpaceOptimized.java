/*

* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(m*n)
* 
* Space Complexity: O(n)
* 
*/

public class MaximalSquareSpaceOptimized {
    // int maxSquareSize = 0;

    // public int maximalSquare(char[][] matrix) {
    // int m = matrix.length;

    // int n = matrix[0].length;

    // int[] prev = new int[n];
    // int[] curr = new int[n];

    // for (int row = m - 1; row >= 0; row--) {
    // for (int col = n - 1; col >= 0; col--) {
    // if (matrix[row][col] == '1') {
    // int diag = 0, right = 0, down = 0;

    // if (col + 1 < n) {
    // diag = prev[col + 1];
    // }

    // down = prev[col];

    // if (col + 1 < n) {
    // right = curr[col + 1];
    // }

    // curr[col] = Math.min(Math.min(down, right), diag) + 1;

    // maxSquareSize = Math.max(maxSquareSize, curr[col]);

    // } else {
    // curr[col] = 0;
    // }
    // }
    // prev = curr.clone();
    // }

    // return maxSquareSize * maxSquareSize;
    // }

    int maxSquareSize = 0;

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;

        int n = matrix[0].length;

        int[] curr = new int[n];

        for (int row = m - 1; row >= 0; row--) {
            int diagDown = 0;

            for (int col = n - 1; col >= 0; col--) {
                int temp = curr[col];

                if (matrix[row][col] == '1') {
                    int right = 0, down = 0;

                    down = curr[col];

                    if (col + 1 < n) {
                        right = curr[col + 1];
                    }

                    curr[col] = Math.min(Math.min(down, right), diagDown) + 1;

                    maxSquareSize = Math.max(maxSquareSize, curr[col]);

                } else {
                    curr[col] = 0;
                }

                diagDown = temp;
            }
        }

        return maxSquareSize * maxSquareSize;
    }
}
