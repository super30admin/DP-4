//https://leetcode.com/problems/maximal-square/
// Time Complexity : O(m*n) 
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

class Solution {
    public int maximalSquare(char[][] matrix) {
        int r=matrix.length,c=matrix[0].length;
        int dp[][]=new int[r+1][c+1];
        int max=0;
        for(int i=1;i<r+1;i++) //the for loop for dp runs from 1 to r+1 because we have added dummy
        {
            for(int j=1;j<c+1;j++)
            {
                if(matrix[i-1][j-1]=='1') //do only if original element is 1
                {
                    dp[i][j]=1+Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1])); //checking top dig left,left elements
                    max=Math.max(dp[i][j],max);
                }
            }
        }
        return max*max;
        
        
    }
}