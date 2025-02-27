/**
 * Time Complexity: O(nk)
 * Space Complexity: O(n)
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None

 * Approach:
 * Use DP array and compute max sum at each level before proceeding to next index in that array
 */

public class PartitionArrayForMaxSum {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int len = arr.length;
        int[] dp = new int[len];
        dp[0] = arr[0];

        for (int i = 1; i < len; i++) {
            int max = arr[i];
            for (int j = 1; j <=k && i - j + 1 >=0; j++) {
                max = Math.max(max, arr[i - j + 1]);  
                if (i - j >= 0) {
                    dp[i] = Math.max(dp[i-j] + j * max, dp[i]);
                }
                else
                    dp[i] = Math.max(dp[i], j* max);
            }
        }

        return dp[len - 1];
    }
    public static void main(String[] args) {
        // Your code here
    }
}