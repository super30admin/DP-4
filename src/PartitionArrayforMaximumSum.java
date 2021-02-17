
/*  The complexity of the brute force algorithm is O(n*k) where n is length of array  and k is size of partition.
 * Space complexity is O(n) n is length of dp array.
 */

public class PartitionArrayforMaximumSum {

	public int maxSumAfterPartitioning(int[] arr, int k) {

		if (arr.length == 0 || arr == null)
			return 0;

		int[] dp = new int[arr.length];

		for (int i = 0; i < dp.length; i++) {
			int max = arr[i];

			for (int j = 1; j <= k && i - j + 1 >= 0; j++) {

				max = Math.max(max, arr[i - j + 1]);

				if (i - j >= 0)
					dp[i] = Math.max(dp[i], dp[i - j] + max * j);
				else
					dp[i] = Math.max(dp[i], max * j);

			}

		}

		return dp[arr.length - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
