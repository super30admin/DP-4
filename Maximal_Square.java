//Time Complexity : O(mn)
//Space Complexity : O(mn), dp matrix
class Solution {
    public int maximalSquare(char[][] matrix) {
        //m,n row,column
        int m = matrix.length; int n = matrix[0].length;
        //initialize max
        int max = 0;
        int [][] dp = new int[m+1][n+1];
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                //if we come around 1
                if(matrix[i-1][j-1] == '1'){
                    //check up,left,upleft minimum of those add 1
                    dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
                    //the max length
                    max = Math.max(max,dp[i][j]);
                }
            }
        }
        //return the square of it
        return max*max;
    }
}