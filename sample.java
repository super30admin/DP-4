// Time Complexity : O(mn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int maximalSquare(char[][] matrix) 
    {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] cache = new int[m + 1][n + 1];
        int maxWidth = 0;
        
        for(int i = 1; i < m + 1; i++)
        {
           for(int j = 1; j < n + 1; j++)
           {
               if(matrix[i-1][j-1] == '1')
               {
                   int top = cache[i-1][j];
                   int left = cache[i][j-1];
                   int topLeft = cache[i-1][j-1];
                   int min = Math.min(top, Math.min(left, topLeft));
                   cache[i][j] = min + 1;
                   
                   //Update the max width
                   maxWidth = Math.max(maxWidth, cache[i][j]);
               }
           } 
        }
        return maxWidth * maxWidth;
        
    }
}

// Time Complexity : O(nk)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, I couldn't understand the example on leetcode.

class Solution 
{
    public int maxSumAfterPartitioning(int[] arr, int k) 
    {
        int n = arr.length;
        int[] dp = new int[n];
        
        dp[0] = arr[0];
        int max = arr[0];
        
        for(int i = 1; i < k; i++)
        {
            max = Math.max(max, arr[i]);
            dp[i] = max * (i+1);
        }
        
        for(int i = k; i < n; i++)
        {
            int maxSubArray = arr[i];
            for(int subArraySize = 1; subArraySize <= k; subArraySize++)
            {
                maxSubArray = Math.max(maxSubArray, arr[i - subArraySize + 1]);
                dp[i] = Math.max(dp[i], dp[i-subArraySize] + maxSubArray * subArraySize);
            }
        }
        return dp[n-1];
    }
}