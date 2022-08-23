//Time Complexity: O(n*k)
//Space Complexity: O(n)
//Code run successfully on LeetCode.

public class Problem2_2 {

    public int maxSumAfterPartitioning(int[] arr, int k)
    {
        if(arr == null || arr.length == 0)
            return -1;
        
        int n = arr.length;
        
        int[] dp = new int[n];
        dp[0] = arr[0];
        
        for(int i =1; i < n; i++)
        {
           int max = 0;
            
           for(int j = i; j > i-k; j--)
           {
               if(j >= 0)
               {
                   max = Math.max(max, arr[j]);
                   if(j == 0)
                       dp[i] = Math.max(dp[i], max*(i-j+1));
                   
                   else
                       dp[i] = Math.max(dp[i], max*(i-j+1) + dp[j-1]);
               }
               else 
                   break;
           }
        }   
        
        return dp[n-1];
    } 
}
