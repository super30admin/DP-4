// Time Complexity : O(nxm)
// Space Complexity :O(nxm)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :No
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length==0) return 0;
        int R = matrix.length;
        int C = matrix[0].length;
        int maxLen = 0;
        int[][] dp = new int[R+1][C+1];
        for(int i = 1; i <=R;i++)
        {
            for(int j = 1; j <=C;j++)
            {
                if(matrix[i-1][j-1]=='1')
                {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1])+1;
                    if(maxLen<dp[i][j])
                        maxLen=dp[i][j];
                }
            }
        }
        return maxLen*maxLen;
        
    }
}