// Time Complexity = O(nk)
// Space Complexity = O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :Difficult to understand, need to revise


// Your code here along with comments explaining your approach
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if(arr == null || arr.length == 0) return 0;

        int n = arr.length;
        // increase size of dp, using coins change concept
        int[] dp = new int[n + 1];

        // i hold the index of dp
        for(int i = 1; i <= n; i++)
        {
            int maxElement = 0;
            // try getting max element for valid window size from index i
            //eg: When at i = 1 max window possible would be 1, if you increase window to k will get out of bound when calculating arr[]
            for(int j = 1; j <= Math.min(i, k); j++) // if i = 4 then it is possible to make window till size k (where k = 3)
            {
                //i-j is index of element in arr when window size is j
                maxElement = Math.max(maxElement, arr[i-j]);
                dp[i] = Math.max(dp[i], (maxElement * j) + dp[i-j]);
            }
        }

        return dp[arr.length];
    }
}