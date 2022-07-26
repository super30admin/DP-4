class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        # DP TC - O(n*k) SC - O(n)
        n = len(arr)
        dp = [0] * n
        dp[0] = arr[0]
        for i in range(1, n):
            maxx = arr[i]
            for j in range(1, k + 1):
                if i - j + 1 >= 0:
                    maxx = max(maxx, arr[i - j + 1])
                    curr = 0
                    if i - j >= 0:
                        curr = dp[i - j] + j * maxx
                    else:
                        curr = j * maxx
                    dp[i] = max(dp[i], curr)
        return dp[-1]

