// Time Complexity : O(m * n)
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    public int maximalSquare(char[][] matrix) {
        //edge 
        if(matrix == null || matrix.length == 0) return 0;
        //set m and n 
        int m = matrix.length; 
        int n = matrix[0].length;
        //set a dp array to check largest possible square 
        int [][] dp = new int[m+1][n+1];
        //set a max count
        int count = 0;
        //start for loop to iterate through matrix
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                //check if we land on a 1 
                if(matrix[i-1][j-1] == '1'){
                    //set the dp matrix value to min the surroundings
                    dp[i][j] = 1 + Math.min(dp[i-1][j] , Math.min(dp[i][j-1],dp[i-1][j-1]));
                    //set the max
                    count = Math.max(count,dp[i][j]);
                }
            }
        }
        //return the area
        return count*count;
    }
}