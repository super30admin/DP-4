// Time Complexity : o(mn)
// Space Complexity : o(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
  
    // bruth force approach
    /*
    public int maximalSquare(char[][] matrix) {
        
        if(matrix==null|| matrix.length==0)
            return 0;
        
        int m=matrix.length;
        int n=matrix[0].length;
        
        int curr=0,max=0;
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                boolean flag=false;
                if(matrix[i][j]=='1')
                {
                    flag=true;
                    curr=1;
                    while(i+curr < m && j+curr < n && flag)
                    {
                        //column check
                        for(int k=i+curr;k>=i;k--)
                        {
                            if(matrix[k][j+curr]=='0')
                            {
                                flag=false;
                                break;
                            }
                        }
                        
                        //row check
                         for(int k=j+curr;k>=j;k--)
                        {
                            if(matrix[i+curr][k]=='0')
                            {
                                flag=false;
                                break;
                            }
                        }
                        
                        if(flag)
                            curr++;
                    }
                }
                max=Math.max(max,curr);
            }
        }
        return max*max;
    }
    */
    
    // Dp Approach
     public int maximalSquare(char[][] matrix) {
         
          if(matrix==null|| matrix.length==0)
            return 0;
        
        int m=matrix.length;
        int n=matrix[0].length;
        
        int max=0;
         int[][] dp=new int[m+1][n+1];
        
        for(int i=1;i<m+1;i++)
        {
            for(int j=1;j<n+1;j++)
            {
                
                if(matrix[i-1][j-1]=='1')
                {
                    
                        dp[i][j]=Math.min(dp[i][j-1],Math.min(dp[i-1][j-1],dp[i-1][j]))+1;
                    max=Math.max(max,dp[i][j]);
                      
                }
                
            }       
        }
        
     return max*max;
     }
}