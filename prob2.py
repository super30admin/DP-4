# Time Complexity :O(kn)
# Space Complexity :O(n)
# Leet Code: Yes

class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        
        n = len(arr)
        dp = [0 for _ in range(n)]
        dp[0] = arr[0]
        for i in range(1, n):
            maxVal = arr[i]
            for j in range(1, k+1):
                if i-j+1 >= 0:
                    maxVal = max(arr[i-j+1], maxVal)
                    if i-j >= 0:
                        dp[i] = max(dp[i], j*maxVal + dp[i-j])
                    else:
                        dp[i] = max(dp[i], j*maxVal)

        return dp[n-1]
