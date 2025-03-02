# This approach is O(n*k) time and O(n) space
# We try to store the maximum at each place and try to see the size of k array's max

class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        if not arr or k == 0:
            return 0
        
        n = len(arr)
        dp = [0] * n
        dp[0] = arr[0]
        for i in range(1, n):
            maxi = arr[i]
            for j in range(1, k + 1):
                if i - j + 1 >= 0:
                    maxi = max(maxi, arr[i - j + 1])
                    if i - j >= 0:
                        dp[i] = max(dp[i], dp[i - j] + j * maxi)
                    else:
                        dp[i] = max(dp[i], j * maxi)
            
        return dp[n - 1]