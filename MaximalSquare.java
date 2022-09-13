// Time Complexity : O(m*n) where m = number of rows, n = number of columns
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//221. Maximal Square (Medium) - https://leetcode.com/problems/maximal-square/
class Solution {
    public int maximalSquare(char[][] matrix) {
    	// Time Complexity : O(m*n*m*n) where m = number of rows, n = number of columns
    	// Space Complexity : O(1)
//        if (matrix == null || matrix.length == 0) return 0;
//        
//        int m = matrix.length, n = matrix[0].length;
//        boolean flag = false;
//        int max = Integer.MIN_VALUE;
//        
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (matrix[i][j] == '1') {
//                    flag = true;
//                    int side = 1;
//                    
//                    while (i+side < m && j+side < n && flag) {
//                        // check if for same column, are all elements 1's
//                        for (int row = i+side; row >= i; row--) {
//                            if (matrix[row][j+side] == '0') {
//                                flag = false;
//                                break;
//                            }
//                        }
//                        
//                        if (flag) {
//                            // check if for same row, are all elements 1's
//                            for (int col = j+side; col >= j; col--) {
//                                if (matrix[i+side][col] == '0') {
//                                    flag = false;
//                                    break;
//                                }
//                            }
//                        }
//                        
//                        
//                        if (flag) side++;
//                    }
//                    max = Math.max(max, side);
//                }
//            }
//        }
//        
//        return max*max;
    	
    	// Time Complexity : O(m*n) where m = number of rows, n = number of columns
    	// Space Complexity : O(m*n) where m = number of rows, n = number of columns
//    	if (matrix == null || matrix.length == 0) return 0;
//        
//        int m = matrix.length, n = matrix[0].length, max = 0;
//        int[][] dp = new int [m+1][n+1];
//        
//        for (int i = 1; i <= m; i++) {
//            for (int j = 1; j <= n; j++) {
//                if (matrix[i-1][j-1] == '1') {
//                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]));
//                    max = Math.max(max, dp[i][j]);
//                }
//            }
//        }
//        
//        return max*max;
    	
    	// Time Complexity : O(m*n) where m = number of rows, n = number of columns
    	// Space Complexity : O(1)
    	if (matrix == null || matrix.length == 0) return 0;
        
        int m = matrix.length, n = matrix[0].length, max = 0;
        // int[][] dp = new int [m+1][n+1];
        
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == '1') {
                max = 1;
            }
        }
        
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == '1') {
                max = 1;
            }
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    int up = matrix[i-1][j] - '0';
                    int left = matrix[i][j-1] - '0';
                    int diagonalUp = matrix[i-1][j-1] - '0';
                    int curr = 1 + Math.min(diagonalUp, Math.min(up, left));
                    max = Math.max(max, curr);
                    matrix[i][j] = (char) (curr + '0');
                }
            }
        }
        
        return max*max;
    }
}