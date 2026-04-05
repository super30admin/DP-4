""" 
1. Compute the max sum you can obtain in an interval i top i + k recursively
2. Compute when you start from i + 1,.... last element
3. Since we will compute whats the max sum we couldve got when we start at i + 1 when starting at i, we can save recomputations by storing it

TC: O(nk)
SC: O(n)
"""

class Solution:
    def maxSum(self, arr, k, dp, start):

        n = len(arr)

        if start >= n:
            return 0

        if dp[start] != -1:
            return dp[start]

        # maxSum per window
        curMax = 0
        # Store Max sum
        ans = 0
        # Window range is from start to start + k - 1 or n
        end = min(start + k, n)
        for i in range(start, end):
            curMax = max(arr[i], curMax)

            # Max sum possible is the max between current maxsum and current computed max + what we wouldve gotten if we started with index 1 
            # Current max sum = length of window * curmax
            ans = max(ans, curMax * (i - start + 1) + self.maxSum(arr, k, dp, i + 1))

        dp[start] = ans
        return ans


    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:

        dp = [-1] * len(arr)
        return self.maxSum(arr, k, dp, 0)
