// top-down dp
// tc: O(N.K) sc:O(N)

class Solution {

  private int maxSum(int[] arr, int k, int[] dp, int start) {
    int N = arr.length;

    if (start >= N) {
      return 0;
    }

    // Return the already calculated answer.
    if (dp[start] != -1) {
      return dp[start];
    }

    int currMax = 0, ans = 0;
    int end = Math.min(N, start + k);
    for (int i = start; i < end; i++) {
      currMax = Math.max(currMax, arr[i]);
      // Store the maximum of all options for the current subarray.
      ans =
        Math.max(ans, currMax * (i - start + 1) + maxSum(arr, k, dp, i + 1));
    }

    // Store the answer to be reused.
    return dp[start] = ans;
  }

  public int maxSumAfterPartitioning(int[] arr, int k) {
    int[] dp = new int[arr.length];
    Arrays.fill(dp, -1);

    return maxSum(arr, k, dp, 0);
  }
}

// bottom-up dp

class Solution {

  public int maxSumAfterPartitioning(int[] arr, int k) {
    int N = arr.length;

    int[] dp = new int[N + 1];
    Arrays.fill(dp, 0);

    for (int start = N - 1; start >= 0; start--) {
      int currMax = 0;
      int end = Math.min(N, start + k);

      for (int i = start; i < end; i++) {
        currMax = Math.max(currMax, arr[i]);
        // Store the maximum of all options for the current subarray.
        dp[start] = Math.max(dp[start], dp[i + 1] + currMax * (i - start + 1));
      }
    }
    return dp[0];
  }
}
