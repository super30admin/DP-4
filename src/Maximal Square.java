// Time Complexity :O(mn)
// Space Complexity :O(mn)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No
class Solution {
    public int maximalSquare(char[][] matrix) {
        //base
        if(matrix == null || matrix.length==0) return 0;
        int[][] dp =  new int[matrix.length][matrix[0].length];
        int max = 0;
        for(int i = 0;i<dp.length;i++){
            if(matrix[i][0]=='1') dp[i][0]=1;
            else dp[i][0]=0;
            max = Math.max(dp[i][0],max);
        }
        for(int j=0;j<dp[0].length;j++){
            if(matrix[0][j]=='1') dp[0][j]=1;
            else dp[0][j]=0;
            max = Math.max(dp[0][j],max);
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(matrix[i][j]=='1'){
                    dp[i][j]= 1+Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));
                    max = Math.max(dp[i][j],max);
                }
            }
        }
        return max*max;
        
    }
}