#Time Complexity = O(nk)
#Space Complexity = O(n)
class Solution:
    def maxSumAfterPartitioning(self, arr, k):
        n = len(arr)
        dp = [0] * n  # DP array to store max sum
        for i in range(n):
            maxVal = 0
            for j in range(i, max(i - k, -1), -1):  #partitions till k size
                maxVal = max(maxVal, arr[j])  # Max in current 
                if j == 0:
                    dp[i] = max(dp[i], maxVal * (i - j + 1))
                else:
                    dp[i] = max(dp[i], dp[j - 1] + maxVal * (i - j + 1))
        return dp[-1] 