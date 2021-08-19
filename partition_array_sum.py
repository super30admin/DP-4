#Time Complexity : O(NK)
#space complexity : O(N)
class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        n = len(arr)
        dp = [0] * n
        curMax = 0
        for i in range(n):
            if i < k: 
                curMax = max(curMax, arr[i])
                dp[i] = curMax * (i + 1)
            else:
                curMax = 0
                for j in range(1, k+ 1):
                    curMax = max(arr[i - j + 1], curMax)
                    dp[i] = max(dp[i], dp[i - j] + curMax * j)
        return dp[- 1]
        