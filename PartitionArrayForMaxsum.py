# TC: O(n*k)
# SC: O(n)
# Subproblem- at each cell, we store max partition sum up until then. 
# usual case: dp[i] = max(dp[i], max*j + dp[i-j])
# if all elements up until now including current element is part of partition under consideration - dp[i] = max(dp[i], max*j)

class Solution:
    def maxSumAfterPartitioning(self, arr):
        if not arr: return 0
        n = len(arr)
        dp = [0 for i in range(n)]
        
        for i in range(n):
            max_ = dp[i]
            for j in range(1, k+1):
                if i-j+1 >= 0:
                    max_ = max(max_, arr[i-j+1])
                    if i-j>=0:
                        dp[i] = max(dp[i], max_*j + dp[i-j])
                    else:
                        dp[i] = max(dp[i], max_*j)
        return dp[-1]
         