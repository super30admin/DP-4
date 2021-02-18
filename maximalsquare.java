//Time Complexity: o(m*n)
//Space Complexity: o(m*n)
class Solution {
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        int m = matrix.length; int n = matrix[0].length;
        int[][] dp =  new int[m][n];
        for(int i = 0; i<m; i++)
        {
            for(int j =0; j<n; j++)
            {
                //Copy the elements in integer form
                if(matrix[i][j] == '0') dp[i][j] = 0;
                else if(matrix[i][j] == '1') dp[i][j] = 1;
                //perform dp on the elements
                if(i==0 || j ==0){ 
                    max = Math.max(max, dp[i][j]);
                    continue;
                }
                else if(matrix[i][j] == '0'){
                    continue;
                }
                else {
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1])) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max*max;
    }
}