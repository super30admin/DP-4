// Time Complexity - O(mn) where m is the number of rows and n is the number of columns
// Space Complexity- O(mn) where m is the number of rows and n is the number of columns; space used by the dp matrix
// This Solution worked on LeetCode
// To calculate the maximum length of the square, we need to find the minimum of the previous value vertically, horizontally and diagonally and add one to it. So, if the minimum is 0, it means a square of length 1 will be formed using the 1 element in process. and if the minimum is 1 it means a square of length 2 can be formed. and so forth. The maximum value obtained will the max length of the square.

class Solution {
    public int maximalSquare(char[][] matrix) {
        int max =0;
        if(matrix == null || matrix.length==0)  return max;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows+1][cols+1];
        for(int i=1;i <= rows;i++){
            for(int j=1;j <= cols;j++){
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1])+1;
                    max = Math.max(max,dp[i][j]);
                }
            }
        }
        return max*max;
    }
}
