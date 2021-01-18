// Time Complexity : O(m*n) 
// Space Complexity :O(m*n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  No


// Your code here along with comments explaining your approach:Traverse the given array and if it is 1, update the new array with the 1+minimum
// of the before 3 elements. Also maintain the max and return its square.
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix==null ||matrix.length == 0)
            return 0;
        int[][] dp = new int[matrix.length+1][matrix[0].length+1];
        int result=0;
        for(int i=1;i<=matrix.length;i++){
            for(int j=1;j<=matrix[0].length;j++){
                if(matrix[i-1][j-1]=='1'){
                    dp[i][j]=Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]))+1;
                    result=Math.max(dp[i][j],result);
                }
            }
        }
        return result*result;
    }
}