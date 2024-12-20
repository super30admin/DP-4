//221. Maximal Square - https://leetcode.com/problems/maximal-square/description/
//Time Complexity: m^2 * n^2
//Space Complexity: O(1)

//Brute Force:
//Check Diagonal to check if the Matrix has square. All the elements above and below the diagonals should be 1
//Time Limit Exceeded
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == '1'){
                    int diagonalLen = 1;
                    boolean flag = true;
                    while(flag && i+diagonalLen < m && j+diagonalLen < n){
                        //from diagnal till ith row(top)
                        for(int k=i+diagonalLen; k>=i; k--){
                            if(matrix[k][j+diagonalLen]=='0'){
                                flag = false;
                                break;
                            }
                        }
                        //from diagnal till jth column(to left)
                        for(int k=j+diagonalLen; k>=j; k--){
                            if(matrix[i+diagonalLen][k]=='0'){
                                flag = false;
                                break;
                            }
                        }
                        if(flag) diagonalLen++;
                    }
                    max = Math.max(max, diagonalLen);
                }
            }
        }
        return max*max;
    }
}


//Time Complexity: m*n
//Space Complexity: O(1)
//Optimal Solution:
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max=0;

        int[][] dp = new int[m+1][n+1];
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(matrix[i-1][j-1] == '1'){
                    //minimum of row-1, diag-1 and col-1 (top/left and diag-up) +1
                    dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1]));
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max*max;
    }
}