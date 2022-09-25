# Time Complexity : O(nk)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def maxSumAfterPartitioning(self, arr, k):
        dp = [0] * (len(arr))
        dp[0] = arr[0]
        for i in range(1, len(arr)):
            maximum = arr[i]
            for j in range(1,k+1):
                maximum = max(maximum, arr[i-j+1])
                if i-j+1 >= 0:
                    if i-j >= 0:
                        curr = j*maximum + dp[i-j]
                    else:
                        curr = j*maximum
                dp[i] = max(dp[i], curr)
        return dp[-1]