//Time Complexity : O(N^2) 
//Space Complexity : O(N) 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * Take a dp array of size n+1. Then iterate from the last index. At each index,
 * take min of that index + 3 or end of array. For each of the iteration of max
 * k indices, take the max value from each iteration of k values and calculate
 * the sum for the number of iterations and update it in the dp matrix. Finally
 * return dp[0] as answer.
 *
 */
class Solution {
	public int maxSumAfterPartitioning(int[] arr, int k) {
		int n = arr.length;
		int[] dp = new int[n + 1];
		for (int i = n - 1; i >= 0; i--) {
			int maxSum = 0;
			int maxVal = 0;
			int count = 0;
			for (int j = i; j < Math.min(n, i + k); j++) {
				count++;
				maxVal = Math.max(maxVal, arr[j]);
				int sum = count * maxVal + dp[j + 1];
				maxSum = Math.max(maxSum, sum);
			}
			dp[i] = maxSum;
		}
		return dp[0];
	}
}
