# Time Complexity : Add - O(n*k)
# Space Complexity :O(h)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''
1. Use DP to select maximum partition by storing max partition sum in a DP array and varying K, to calculate max
'''

class Solution:
    def maxSumAfterPartitioning(self, A: List[int], K: int) -> int:
        
        rows = len(A)
        dp = [0 for i in range(rows)]
        for i in range(rows):
            max_ = A[i]
            
            for j in range(1, K+1):
                if i-j+1 >= 0:
                    max_ = max(max_, A[i-j+1])
                    dp[i] = max(dp[i], dp[i-j] + max_*j)
                    
        return dp[rows-1]
                    