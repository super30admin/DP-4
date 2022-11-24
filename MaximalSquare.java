// Time Complexity : O(m^2*n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach :
/*
 * Approach 1 - Brute Force
 * 1 - A single 1 is also a square in itself of size 1. Once we encounter a 1, we go it's diagonal element and then
 * traverse up and left from that element. Once we hit a 0, we break.
 * 2 - If all 1 are found in that square, we increment the var l
 * 3 - In the end, calculate the area and return max
 */

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        // null case
        if (matrix == null || matrix[0].length == 0) {
            return 0;
        }

        int max = 0;
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    int l = 1;
                    boolean flag = true;

                    while (i + l < m && j + l < n && flag) {
                        // check in the diagonal element column if there is any 0
                        for (int k = i + l; k >= i; k--) {
                            if (matrix[k][j + l] == '0') {
                                flag = false;
                                break;
                            }
                        }

                        // check in the diagonal element row if there is any 0
                        for (int k = j + l; k >= j; k--) {
                            if (matrix[i + l][k] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            l++;
                        }
                    }
                    max = Math.max(max, l);
                }
            }
        }
        return max * max;
    }
}
