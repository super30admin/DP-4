// Time Complexity : O(m*n).
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Approach : We performed bottom up recursion and maintained the number of possible square length in a dp matrix. We calculate the max length of square
// possible by adding 1 to the minimum possibilites of it's neighbors. We perform this check on the indices where we encounter 1, which implies a possibility of
// getting a matrix.

class Solution {
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m+1][n+1]; //dp matrix
        for(int i = m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(matrix[i][j] == '1'){ //we consider to start checking possible squares
                    dp[i][j] = 1 + Math.min(dp[i][j+1], Math.min(dp[i+1][j], dp[i+1][j+1])); //1+min values of neighbor possible matrix values
                    max = Math.max(max, dp[i][j]);//max square length
                } else{
                    dp[i][j] = 0;
                }
            }
        }
        return max*max; //area
    }
}