# TC : O(nk)
# SC : O(n)
class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int: 
        if len(arr) == 0 or k == 0:
            return 0
        n = len(arr)
        dp = [0]*(n)
        dp[0] = arr[0]
        for i in range(1, n):
            max1 = arr[i] # define maximum element
            for j in range(1, k+1):
                if i - j + 1 < 0:
                    break
                max1 = max(max1, arr[i - j +1])
                if i -j >= 0 :
                    dp[i] = max(dp[i], dp[i-j] + j*max1)
                else:
                    dp[i] = max(dp[i], max1 * j)
        return dp[n-1]

        