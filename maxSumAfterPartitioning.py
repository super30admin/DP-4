# Time Complexity : O(nk)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        n = len(arr)
        dp = [0]*(n+1)

        for i in range(1, n+1):
            window_max = 0
            for window_size in range(1, k+1):
                if i-window_size < 0:
                    break
                window_max = max(window_max, arr[i-window_size])
                dp[i] = max(dp[i], dp[i-window_size]+window_max*window_size)

        return dp[-1]
