// DP Solution
// Time - O(MN)
// Space - O(MN)

class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return 0;
        }
        
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        int max =0;
        
        for(int i=1;i<dp.length;i++) {
            for(int j=1;j<dp[0].length;j++) {
                if(matrix[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
}

// Brute Force
// Time - O(MN)^2
// Space - O(1)

class Solution {
    public int maximalSquare(char[][] matrix) {
        
        if(matrix == null || matrix.length == 0) {
            return 0;
        }
        
        int max = 0;
        
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                if(matrix[i][j] == '1') {
                    int k = 1;
                    boolean isSquare = true;
                    while(i + k < matrix.length && j + k < matrix[0].length && isSquare)  {
                        // check the row                         
                        for(int col = j + k; col >= j ; col--) {
                            if(matrix[i + k][col] == '0') {
                                isSquare = false;
                                break;
                            }
                        }
                        // check the col
                        for(int row = i + k; row >= i ; row--) {
                            if(matrix[row][j + k] == '0') {
                                isSquare = false;
                                break;
                            }
                        }
                        if(isSquare) {
                            k++;
                        }                                                
                    }
                max = Math.max(max, k);                    
                }
            }
        }
        
        return max * max;
    }
}
