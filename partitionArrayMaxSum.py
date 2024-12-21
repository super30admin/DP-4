# Time:O(n*k) for n in array and k exhaust
# Space:O(n) for dp array
# Leetcode: Yes
# Issues: range(m+1) if <=m ;range(m) if <m ; reverse is (m-1,-1,-1)


class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        n = len(arr)
        dp = [0] * n
        dp[0] = arr[0]                                                  

        for i in range(n):
            mx = arr[i]                                                         # max for every k
            for j in range(1,k+1):
                if i-j+1 >= 0:                                                  # k limit
                    mx = max(mx, arr[i-j+1])                                    # incoming number
                    dp[i] = max(dp[i], (dp[i-j] if i-j >= 0 else 0) + j * mx)   # element prior to j; if fresh the 0

        return dp[-1]
