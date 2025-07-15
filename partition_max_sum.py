# Time complexity: O(n x k)
# Space complexity: O(n)
def maxSumAfterPartitioning(arr, k):
    n = len(arr)
    dp = [0] * (n + 1)

    for i in range(1, n + 1):
        for j in range(1, min(i, k) + 1):
            dp[i] = max(dp[i], dp[i - j] + max(arr[i - j:i]) * j)

    return dp[n]
