class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        """
        Approach:
        1. Use bottom-up dynamic programming.
        2. dp[i] represents the maximum sum we can get for the subarray arr[0..i].
        3. For each position i, we try all partition sizes j from 1 to k:
            - Track the maximum element in the current partition (currMax)
            - Calculate the sum of the partition as (currMax * j)
            - Add it to dp[i-j] if i-j >= 0
        4. Store the max of all these options in dp[i]

        Time Complexity: O(n * k) — For each of the n elements, we try up to k partitions.
        Space Complexity: O(n) — One DP array of size n is used.
        """
        n = len(arr)
        dp = [0] * n
        dp[0] = arr[0]

        for i in range(1, n):
            currMax = 0
            for j in range(1, k + 1):
                if i - j + 1 >= 0:
                    currMax = max(currMax, arr[i - j + 1])
                    if i - j >= 0:
                        dp[i] = max(dp[i], currMax * j + dp[i - j])
                    else:
                        dp[i] = max(dp[i], currMax * j)

        return dp[n - 1]
