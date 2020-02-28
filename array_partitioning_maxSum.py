"""
Time Complexity : O(n) 
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this: none
"""

class Solution:
    def maxSumAfterPartitioning(self, A, K):
        n = len(A)
        dp = [0]*n
        i = 0
        
        while i < n:
            max_elem = 0
            j = 1
            while i-j+1 >= 0 and j <= K:
                max_elem = max(max_elem, A[i-j+1])
                if i >= j:
                    dp[i] = max(dp[i], j*max_elem + dp[i-j])
                else:
                    dp[i] = max(dp[i], max_elem*j) 
                j += 1
            i+= 1
                         
        return dp[-1]
    
s = Solution()
print(s.maxSumAfterPartitioning([1,15,7,9,2,5,10], 3))