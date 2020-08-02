// Time Complexity : O(m^2 * n^2)
// Space Complexity : O(1)
// https://leetcode.com/problems/maximal-square/

//Brute Force
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix==null || matrix.length==0) return 0;
        int m=matrix.length; int n=matrix[0].length;
        int max=0;boolean flag=false;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]=='1')
                {
                    int curr=1; flag=true;
                    while(i+curr<m && j+curr<n && flag)
                    {
                        for(int k=i+curr; k>=i;k--)
                        {
                            if(matrix[k][j+curr]=='0')
                                flag=false;
                        }
                        for(int k=j+curr; k>=j;k--)
                        {
                            if(matrix[i+curr][k]=='0')
                                flag=false;
                        }
                        if(flag)
                            curr++;
                        max=Math.max(max,curr);
                        
                    }
                }
            }
        }
        return max*max;
    }
}

//DP
TC:O(m*n)
SC:O(m*n)
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix==null || matrix.length==0) return 0;
        int m=matrix.length; int n=matrix[0].length;
        int max=0;
        int dp[][]=new int[m+1][n+1];
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(matrix[i-1][j-1]=='1')
                {
                    dp[i][j]=1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                    max=Math.max(max,dp[i][j]);
                    
                }

            }
        }
        return max*max;
    }
}