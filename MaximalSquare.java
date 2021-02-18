// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        //edge
        if(matrix == null || matrix.length == 0) return 0;
        int m = matrix.length; int n = matrix[0].length;

        int [][] dp = new int[m+1][n+1];

        int max = 0;
        //loop through matrix
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                //if element is 1
                if(matrix[i-1][j-1] == '1'){
                    //elements gets min of adjacent plus 1
                    dp[i][j] = 1 + Math.min(dp[i-1][j] , Math.min(dp[i][j-1],dp[i-1][j-1]));
                    //set the max
                    max = Math.max(max,dp[i][j]);
                }
            }
        }
        //return the area
        return max*max;
    }
}