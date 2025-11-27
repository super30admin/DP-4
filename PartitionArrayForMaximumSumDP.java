/**
 * Partition Array for Maximum Sum — LeetCode 1043
 * https://leetcode.com/problems/partition-array-for-maximum-sum/
 *
 * Approach:
 * This is a bottom-up dynamic programming solution. dp[i] stores the maximum
 * sum achievable for the subarray arr[0..i]. For each i, we consider all
 * partition lengths up to k that end at i, track the maximum value in the
 * partition and update dp[i] using dp[i - len] + maxVal * len (handle base
 * when the partition reaches the array start).
 *
 * Time Complexity: O(n * k) where n = arr.length and k is the maximum partition length.
 * Space Complexity: O(n) for the dp array.
 */
public class PartitionArrayForMaximumSumDP {

    int[] dp;

    public int maxSumAfterPartitioning(int[] arr, int k) {
        dp = new int[arr.length];
        dp[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int currMax = 0;
            for (int j = 0; j < k && i - j >= 0; j++) {
                currMax = Math.max(currMax, arr[i - j]);
                if (i - j - 1 >= 0)
                    dp[i] = Math.max(dp[i], dp[i - j - 1] + (currMax * (j + 1)));
                else
                    dp[i] = Math.max(dp[i], (currMax * (j + 1)));
            }
        }
        return dp[arr.length-1];
    }

}
