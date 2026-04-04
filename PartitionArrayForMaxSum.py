# Time Complexity : O(n * k)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : We use a bottom-up dp array to track max sum up to each index.
# For every index i, we check all partitions of size up to k ending at i.
# We calculate the contribution from the max element and update dp[i] accordingly.

class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        n = len(arr)
        dp = [0] * n
        dp[0] = arr[0]

        for i in range(1, n):
            currMax = 0
            for j in range(1, k+1):
                if i-j+1 < 0:
                    break
                currMax = max(currMax, arr[i - j + 1])
                if i - j >= 0:
                    dp[i] = max(dp[i], currMax * j + dp[i - j])
                else:
                    dp[i] = max(dp[i], currMax * j)
        
        return dp[n - 1]
        