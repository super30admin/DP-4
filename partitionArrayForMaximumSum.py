#Time Complexity : O(nk) where n is the length of the given list and k is the given partition size
#Space Complexity : O(n) where n is the length of the given list
#Did this code successfully run on Leetcode : Yes

class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        if not arr:
            return 0
        n = len(arr)
        dp = [0] * (n+1)
        for i in range(n):
            currMax = arr[i]
            j = 1
            while  i-j+1 >= 0 and j <= k:
                currMax = max(currMax, arr[i-j+1])
                if i-j >= 0:
                    dp[i] = max(dp[i], dp[i-j] + currMax*j)
                else:
                    dp[i] = max(dp[i], currMax*j)
                j += 1

        return dp[n-1]
