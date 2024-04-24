

// Problem1:(https://leetcode.com/problems/maximal-square/)
// Time Complexity : O(mn)
// Space Complexity : O(mn) for dp matrix
// Did this code successfully run on Leetcode : yes

class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix==null || matrix.length==0)
            return 0;
        int m=0;
        int dp[][]=new int[matrix.length+1][matrix[0].length+1];
        for(int i=matrix.length-1;i>=0;i--)
        {
            for(int j=matrix[0].length-1;j>=0;j--)
            {
                if(matrix[i][j]=='1')
                {
                    dp[i][j]=Math.min(Math.min(dp[i+1][j+1],dp[i+1][j]),dp[i][j+1])+1;
                    m=Math.max(m,dp[i][j]);
                }  
            }
        }
        return m*m;  
    }
}





// Problem2:(https://leetcode.com/problems/partition-array-for-maximum-sum/)
// Time Complexity : O(n.k)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes


class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int dp[]=new int[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            int max=arr[i];
            for(int j=1;j<=k && i-j+1>=0;j++)
            {
                max=Math.max(max,arr[i-j+1]);
                int currval=j*max;
                if(i-j>=0)   //if left array exists
                    currval=dp[i-j]+(j*max);
                dp[i]=Math.max(dp[i],currval);
            }
        }
        return dp[arr.length-1];   
    }
}



