// Time Complexity : O(n * k)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//We use a bottom-up dp array to track max sum up to each index.
//For every index i, we check all partitions of size up to k ending at i.
//We calculate the contribution from the max element and update dp[i] accordingly.

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        int n = arr.length;
        dp[0] = arr[0];
        int max = 0;
        for(int i=1; i < n; i++) {
            int maxInCurPart = arr[i];
            for(int j = 1; j<=k && i-j+1 >=0; j++) { //j - is num of partitions
                maxInCurPart = Math.max(maxInCurPart, arr[i-j+1]);
                int curMax = maxInCurPart * j;
                int total = curMax;
                if(i - j >= 0) {
                    total = curMax + dp[i-j];
                }
                max = Math.max(max, total);

            }
            dp[i] = max;
        }
        return dp[n-1];
        
    }
}
