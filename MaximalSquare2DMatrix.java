// Time Complexity: O(m^2*n^2) where m and n are the dimensions of the matrix
// Space Complexity: O(1)

class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int m = matrix.length; int n = matrix[0].length;

        // indicates that we have found a 1 at a particular cell
        boolean flag = false;

        int max = 0;

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(matrix[i][j] == '1'){
                    flag = true;
                    int curr = 1; // length of the diagonal element
                    while(i + curr < m && j + curr < n && flag){
                        // iterate on column
                        for(int k = i + curr ; k >= i; k--){
                            if(matrix[k][j+curr] == '0') flag = false;
                        }

                        // iterate on column
                        for(int k = j + curr ; k >= j; k--){
                            if(matrix[i+curr][k] == '0') flag = false;
                        }

                        if(flag) curr++;
                    }
                    max = Math.max(max, curr);
                }
            }
        }
        return max*max;
    }
}

// Approach : Dynamic Programming
// Time Complexity: O(m*n)
// Space Complexity: O(1)

class Solution {
    public int maximalSquare(char[][] matrix){
        if(matrix == null || matrix.length == 0) return 0;
        int m = matrix.length; int n = matrix[0].length;
        int max = 0;
        int[][] dp = new int[m+1][n+1];
        for(int i = 1 ; i < dp.length ; i++){
            for(int j = 1 ; j < dp[0].length ; j++){
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max*max;
    }
}


