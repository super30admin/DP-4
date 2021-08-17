// Time Complexity : O(n*k), n -> Number of elements in the array, k -> Maximum number of elements in the partition
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem2;

public class PartitionArrayForMaximumSum {
	/********************* Dynamic Programming *********************/
	public int maxSumAfterPartitioning(int[] arr, int k) {
		if (arr == null || arr.length == 0 || k == 0) {
			return 0;
		}

		int n = arr.length;
		int[] dp = new int[n];
		dp[0] = arr[0];

		for (int i = 1; i < n; i++) {
			int max = arr[i];

			for (int j = 1; j <= k && (i - j + 1) >= 0; j++) {
				max = Math.max(max, arr[i - j + 1]);
				if (i - j >= 0) {
					dp[i] = Math.max(dp[i], dp[i - j] + max * j);
				} else {
					// For first k elements
					dp[i] = Math.max(dp[i], max * j);
				}
			}
		}

		return dp[n - 1];
	}

	public static void main(String[] args) {
		PartitionArrayForMaximumSum obj = new PartitionArrayForMaximumSum();
		int[] arr = { 1, 15, 7, 9, 2, 5, 10 };
		int k = 3;

		System.out.println("Maximum partition sumL: " + obj.maxSumAfterPartitioning(arr, k));
	}

}
