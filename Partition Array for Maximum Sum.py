""""// Time Complexity : O(n*k)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""


class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        n = len(arr)
        dp = [0 for i in range(n)]
        dp[0] = arr[0]
        for i in range(n):
            maxi = arr[i]
            for j in range(1, k + 1):
                if i - j + 1 >= 0:
                    maxi = max(maxi, arr[i - j + 1])
                    curr = 0
                    if i - j >= 0:
                        curr = j * maxi + dp[i - j]
                    else:
                        curr = j * maxi
                    dp[i] = max(dp[i], curr)
        return dp[-1]
