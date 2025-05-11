/**
 * Maximal Square
 * Time Complexity = O(m^2 * n^2 )
 */

class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int maxDim = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] =='1'){
                    int len = 1;
                    boolean flag = true;

                    while(i+len < m && j+len < n){
                        for(int k= i+len; k>=i; k--){
                            if(matrix[k][j+len] == '0'){
                                flag = false;
                                break;
                            }
                        }

                        for(int k=j+len; k>=j; k--){
                            if(matrix[i+len][k] == '0'){
                                flag = false;
                                break;
                            }
                        }
                        if(flag)
                            len++;
                        else
                            break;
                    }
                maxDim = Math.max(maxDim, len);
                }
            }
        }
        return maxDim*maxDim;
    }
}

/*
 * DP:
 * We form a (m+1*n+1) Integer matrix
 * We start from bottom right or top left corner.
 * We will keep checking the mininum of its neighbours.[Ex: [i][j+1],[i+1][j],[i+1][j+1]]
 * We keep updating the maximum value. That is dp[i][j]
 */

 class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int maxDim = 0;
        //Integer m*n matrix to form max square possible
        int [][] dp = new int[m+1][n+1];
        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                if(matrix[i][j] =='1'){
                    dp[i][j] = 1+Math.min(dp[i][j+1], Math.min(dp[i+1][j], dp[i+1][j+1]));
                    maxDim = Math.max(maxDim, dp[i][j]);
                }
            }
        }
        return maxDim*maxDim;
    }
}