// Time Complexity : O(n*k)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// dp[i] will have the value of best partition formed till i th element
// to find max when we are finding best partition, compare earlier max with incoming max

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int dp[] = new int[n];
        dp[0] = arr[0];
        for(int i=1;i<n;i++){
            int max = arr[i];
            dp[i] = max + dp[i-1];
            for(int j=1;j<k && i-j>=0;j++){
                max = Math.max(max, arr[i-j]);
                if(i-j==0)
                    dp[i] = Math.max(dp[i], max*(j+1));
                else    
                    dp[i] = Math.max(dp[i], dp[i-j-1]+ max*(j+1));
            }
        }
        return dp[n-1];
    }
}