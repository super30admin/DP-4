class Solution:
    # Time Complexity - O(nk)
    # Space Complexity - O(n)
    def maxSumAfterPartitioning(self, arr, k) -> int:
        if arr is None or len(arr) == 0: return 0
        dp = [0] * (len(arr))
        dp[0] = arr[0]
        for i in range(1, len(arr)):
            max_ = arr[i]
            for j in range(1, k + 1):
                if (i - j + 1 >= 0):
                    max_ = max(max_, arr[i - j + 1])
                    if (i - j) >= 0:
                        dp[i] = max(dp[i], max_ * j + dp[i - j])
                    else:
                        dp[i] = max(dp[i], max_ * j)

        return dp[-1]

# This can be further optimized for space - O(n) to O(k)