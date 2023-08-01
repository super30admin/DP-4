package DP_4;

/**
 * Using bottom up dynamic programming where in the dp array each cell
 * represents the maximum possible sum with partitioning upto that point.
 * 
 * Time Complexity : O(nk)- where n is the of rows and k is max size of
 * partitions allowed
 * 
 * Space Complexity : O(n), for the dp array
 * 
 * Did this code successfully run on Leetcode : yes
 * 
 * Any problem you faced while coding this : No
 */
public class Problem2 {
	public int maxSumAfterPartitioning(int[] arr, int k) {
		int dp[] = new int[arr.length];

		dp[0] = arr[0];

		for (int j = 1; j < dp.length; j++) {
			int maxNumPartition = -1;
			for (int i = 0; i < k; i++) {

				// i=0 means a single partition
				int partition = i + 1;

				// j+1 is the number of elements in the partition till now including active
				// element
				int numberOfElements = j + 1;

				if (numberOfElements >= partition) {

					// Max value in the curr partition
					maxNumPartition = Math.max(arr[j - i], maxNumPartition);

					if (numberOfElements == partition) {
						dp[j] = Math.max(dp[j], maxNumPartition * partition);

					} else
						dp[j] = Math.max(dp[j], maxNumPartition * partition + dp[j - partition]);

				}
			}

		}

		return dp[dp.length - 1];

	}
}
