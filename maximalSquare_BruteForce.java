// Time Complexity : O(m^2 * n^2) where m and n are the dimensions of the grid
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class maximalSquare_BruteForce {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null) return 0;
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        int max = 0;
        boolean flag = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = matrix[i][j];
                if (c == '1') {
                    flag = true;
                    int curr = 1;
                    while (i + curr < m && j + curr < n && flag) {
                        // row
                        for (int k = j + curr; k >= j; k--) {
                            if (matrix[i + curr][k] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        // col
                        for (int k = i + curr; k >= i; k--) {
                            if (matrix[k][j + curr] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            curr++;    
                        } 
                    }
                    max = Math.max(max, curr);
                }
            }
        }
        return max*max;
    }
}