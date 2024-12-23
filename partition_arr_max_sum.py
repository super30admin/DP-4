class Solution:
    def maxSumAfterPartitioning(self, arr, k):
        n = len(arr)
        dp = [0] * n
        dp[0] = arr[0]

        for i in range(1, n):
            curr_max = arr[i]
            for j in range(1, k + 1):
                if i - j + 1 >= 0:
                    curr_max = max(curr_max, arr[i - j + 1])
                    if i - j >= 0:
                        dp[i] = max(dp[i], curr_max * j + dp[i - j])
                    else:
                        dp[i] = max(dp[i], curr_max * j)
        return dp[-1]


# time complexity is O(n*k)
# space complexity is O(n)
