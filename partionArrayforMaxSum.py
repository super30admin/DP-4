class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        n = len(arr)
        dp = [0 for i in range(n)]
        for start in range(n - 1, -1, -1):
            currMax = arr[start]
            currMaxSum = 0
            windowSize = min(n, start + k)

            for i in range(start, windowSize):
                currMax = max(currMax, arr[i])
                if i + 1 >= n:
                    currMaxSum = max(currMaxSum, ((i - start + 1) * currMax))
                else:
                    currMaxSum = max(currMaxSum, ((i - start + 1) * currMax) + dp[i + 1])
            dp[start] = currMaxSum
        return dp[0]
