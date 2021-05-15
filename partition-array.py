class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        if arr is None or len(arr) == 0:
            return 0
        n = len(arr)
        dp = [0] * (n)
        for i in range(n):
            max_val = arr[i]
            for j in range(1, k + 1):
                if (i - j + 1) < 0:
                    break
                max_val = max(max_val, arr[i - j + 1])
                if i - j >= 0:
                    dp[i] = max(dp[i], dp[i - j] + max_val * j)
                else:
                    dp[i] = max(dp[i], max_val * j)
        return dp[-1]
