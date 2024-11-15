# Time Complexity : O(k * n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
# Problem Name: Partition Array for Maximum Sum

class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        n = len(arr)
        dp = [0] * n
        dp[0] = arr[0]

        for i in range(n):
            currMax = arr[i]
            for j in range(1, min(k, i + 1) + 1):
                currMax = max(currMax, arr[i-j+1])
                if i - j >= 0:
                    dp[i] = max(dp[i],currMax * j + dp[i-j])
                else:
                    dp[i] = max(dp[i], currMax * j)
        return dp[n-1]