"""
// Time Complexity : o(n*k)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : not on leetcode
// Any problem you faced while coding this : no
"""
class Solution:
    def maxSumAfterPartitioning(self, A: List[int], K: int) -> int:
        if not A :
            return 0
        
        n = len(A)
        
        dp  = [0] * n
        
        for i in range(n):
            m = A[i] #keeps track of max element in the partition
            
            for j in range(1, K + 1): #exploring partitions of all sizes
                if i - j + 1 >= 0:
                    m = max(m, A[i - j + 1]) #update max element 
                    
                    if i >= j:
                        dp[i] = max(dp[i], dp[i - j] + m * j) #considering max value j times(size of partition) 
                    
                    else:
                        dp[i] = max(dp[i], m * j)
                        
        return dp[-1]