# Time Complexity: O(k^n)
# Space Complexity: O(n)
class Solution:
    #   We will be storing maximum of current sub array in the dp array and we will reuse the values
    #   to get the current max value of sub array
    def maxSumAfterPartitioning(self, arr, k):

        n = len(arr)
        dp = [0 for i in range(n + 1)]

        dp[0] = arr[0]

        for i in range(1, n):
            maxl = arr[i]
            for j in range(1, k + 1):
                if i - j + 1 >= 0:
                    maxl = max(maxl, arr[i - j + 1])
                    if i - j >= 0:
                        dp[i] = max(dp[i], dp[i - j] + maxl * j)
                    else:
                        dp[i] = max(dp[i], maxl * j)

        return dp[n - 1]
