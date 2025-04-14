// Time Complexity : O(nk)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes


// Your code here along with comments explaining your approach

class Solution {
  public int maxSumAfterPartitioning(int[] arr, int k) {
    if(arr == null || arr.length == 0) return 0;
    int n = arr.length;
    int[] dp = new int[n];
    dp[0] = arr[0];
    for(int i = 1; i<n; i++) {
      int max = arr[i];
      // Loop till k elements before current element
      for(int j = 1; j<=k && i-j+1>=0; j++) {
        // Updating max
        max = Math.max(max, arr[i-j+1]);
        if(i-j>=0) {
          dp[i] = Math.max(dp[i], dp[i-j] + j*max);
        } else {
          dp[i] = Math.max(max, j*max);
        }
      }
    }
    return dp[n-1];
  }
}