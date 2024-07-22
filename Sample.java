//Problem 1
// TC O(m*n)
//SCO(m*n)
class Solution {
    public int maximalSquare(char[][] matrix) {
     if(matrix==null || matrix.length==0) return 0;
     int m=matrix.length;
     int n=matrix[0].length;
     int dp[][]=new int[m+1][n+1];
     int max=0;

     for(int i=1;i<m+1;i++)
     {
        for(int j=1;j<n+1;j++)
        {
            if(matrix[i-1][j-1]=='1')
            {
                dp[i][j]=1+Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));
                max=Math.max(max,dp[i][j]);
            }
        }
     }
     return max*max;
    }
}

//Problem 2
// TC O(m*k)
//SCO(m)
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if(arr==null || arr.length==0) return 0;
        int dp[]=new int[arr.length];
        dp[0]=arr[0];
        int max;
        for(int i=1;i<arr.length;i++)
        {
            max=arr[i];
            for(int j=1;j<=k&& i-j+1>=0;j++)
            {
                max=Math.max(max,arr[i-j+1]);
                if(i-j>=0)
                {
                    dp[i]=Math.max(dp[i],dp[i-j]+j*max);
                }
                else{
                    dp[i]=Math.max(dp[i],j*max);
                }
            }
            
        }
      return dp[arr.length-1];  
    }
}