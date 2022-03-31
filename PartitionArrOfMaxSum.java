// Time Complexity : O(n*k) n is the size of the array and k is the max partition size
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We will start from the end and calculate max dp possible value store
// Our calculation would include selction or not selection
// This way we will build our dp and dp[0] would have our answer.

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int dp[] = new int[n+1];
        for(int i = n-1; i >= 0; i--){
            int ans = 0, max = 0;
            for(int len = 1; len <= k && len+i-1 < n; len++){
                max = Math.max(max, arr[i + len - 1]);
                ans = Math.max(ans, max*len + dp[i + len]);
            }
            dp[i] = ans;
        }
        return dp[0];
    }
}