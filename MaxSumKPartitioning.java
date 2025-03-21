// Time Complexity : O(kn) where n is the length o fthe array.
// Space Complexity : O(n).
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];

        for(int i=1; i<arr.length; i++)
        {
            int maxElem = arr[i];
            for(int j=i, kt = 1; j>=0 && kt<=k; j--, kt++)
            {
                maxElem = Math.max(maxElem, arr[j]);
                int curr = maxElem*kt;
                if(j==0) 
                    dp[i] = Math.max(dp[i], curr);
                else
                    dp[i] = Math.max(dp[i], curr + dp[j-1]);
            }
        }
        return dp[arr.length-1];
    }
}