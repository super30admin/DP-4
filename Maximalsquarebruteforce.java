// Time Complexity : O(M*N) square
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We will iterate through the matrix and whenever we encounter a '1', we will check for the maximum length of the square that can be formed with that '1' as the top left corner. 
// We will keep track of the maximum length of the square found so far and return the area of that square at the end.
// We will check the right border and the bottom border of the square to ensure that all the elements are '1'. 
// If we encounter a '0', we will break out of the loop and move on to the next '1' in the matrix.
// This is a brute force approach and can be optimized using dynamic programming, but it is a valid solution to the problem.
// Repeated sub problem are present in this approach as we are checking the same sub matrix multiple times, but we are not storing the results of those sub problems, hence it is not a dynamic programming solution.

class Solution {
    public int maximalSquare(char[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int max = 0;

        for (int r = 0; r < m; r++) {

            for (int c = 0; c < n; c++) {

                if (matrix[r][c] == '1') {

                    int len = 1;
                    boolean flag = true;

                    while (r + len < m && c + len < n) {

                        // Check right border
                        for (int k = r + len; k >= r; k--) {
                            if (matrix[k][c + len] == '0') {
                                flag = false;
                                break;
                            }
                        }

                        // Check bottom border
                        for (int k = c + len; k >= c; k--) {
                            if (matrix[r + len][k] == '0') {
                                flag = false;
                                break;
                            }
                        }

                        if (flag) {
                            len++;
                        } else {
                            break;
                        }
                    }

                    max = Math.max(max, len);
                }
            }
        }

        return max * max;
    }
}