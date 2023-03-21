// Time Complexity : O(nk)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/* we add every new number in the array and try to make k number of partitions.
 * For evry partition, we calculate the maximum number which we have to convert to the rest of the numbers in the partition. 
 * add the values to the dp array.
 */
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        
        if(arr == null || arr.length == 0)
        {
            return 0;
        }
        
        int n = arr.length;

        int[] dp = new int[n+1];

        dp[0] = arr[0];

        for(int i = 1; i < n ; i++)
        {
            int max = arr[i];
            for(int j = 1; j <= k && i -j +1 >=0 ;j++)
            {
                max = Math.max(max, arr[i-j+1]);
                int val = max * j;
                if(i-j >= 0)
                {
                    val += dp[i-j];
                }
                dp[i] = Math.max(dp[i] , val);
            }
        }

        return dp[n-1];
    }
}