#Time: O(nk)
#Space: O(n) 

class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        if not arr:
            return 0
        n = len(arr)
        dp = [0] * (n+1)
        for i in range(n):
            currMax = arr[i]
            j = 1
            while  i-j+1 >= 0 and j <= k:
                currMax = max(currMax, arr[i-j+1])
                if i-j >= 0:
                    dp[i] = max(dp[i], dp[i-j] + currMax*j)
                else:
                    dp[i] = max(dp[i], currMax*j)
                j += 1

        return dp[n-1]
