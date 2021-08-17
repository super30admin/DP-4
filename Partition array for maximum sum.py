class Solution:
    def maxSumAfterPartitioning(self, arr, k) :
        if arr == None or len(arr) == 0 or k == 0:
            return 0
        dp = [0 for i in range(len(arr))]
        dp[0] = arr[0]

        for i in range(1, len(dp)):
            maximum = arr[i]
            for j in range(1, k + 1):
                if i - j + 1 >= 0:
                    maximum = max(maximum, arr[i - j + 1])  # incoming element
                    if i - j >= 0:
                        dp[i] = max(dp[i], dp[i - j] + maximum * j)
                    else:
                        dp[i] = max(dp[i], maximum * j)
        return dp[len(arr) - 1]

