class Solution:
    def maxSumAfterPartitioning(self, arr:list[int], k: int) -> int:
        dp = [-1] * len(arr)

        def recurrFunction(ind):
            if ind == len(arr):
                return 0
            currMax = 0
            currSum = 0
            if dp[ind] != -1:
                return dp[ind]
            end = min(ind + k, len(arr))
            for i in range(ind, end):
                currMax = max(currMax, arr[i])
                currSum = max(currSum, currMax * (i - ind + 1) + recurrFunction(i + 1))
            dp[ind] = currSum
            return currSum

        return recurrFunction(0)
