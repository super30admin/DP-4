// Time Complexity : O(n*k)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach :
/*
 * 1 - The idea is to create partitions at each element - single, double and triple partitons.
 * 2 - At each double/triple partition - use the repeated sub problem value.
 * 3 - The important point is to take note of the constraints 
 */

public class PartitionArray {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];
        int max = 0;
        
        for(int i = 0; i < n; i++)
        {
            max = arr[i];
            for(int j = 1;j <= k && i-j + 1 >= 0;j++)
            {
                max = Math.max(max,arr[i - j + 1]);
                int sum = 0;
                if(i - j >= 0)
                {
                    sum = j*max + dp[i - j];
                }
                else
                {
                    sum = j*max;
                }
                dp[i] = Math.max(dp[i],sum);
            }
        }
        return dp[n - 1];
    }
}
