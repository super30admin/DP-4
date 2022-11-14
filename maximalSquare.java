class Solution {
    public int maximalSquare(char[][] matrix) {
        
        int m=matrix.length;
        int n=matrix[0].length;
        
        int[] dp=new int[n+1];
        
        int max=0;
        

        
        for(int i=0;i<m;i++)
        {
            int diagUp=0;
            for(int j=0;j<n;j++)
            {
                int prev=dp[j+1];
                if(matrix[i][j]=='1')
                {
                    dp[j+1]=Math.min(dp[j+1],Math.min(diagUp,dp[j]))+1;
                }
                else
                    dp[j+1]=0;
                diagUp=prev;
                max=Math.max(max,dp[j+1]);
            }
            
        }
        
        return max*max;
        
        
    }
}

// Time Complexity : O(M*N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
