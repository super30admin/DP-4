# Time Complexity : O(A * k)
# Space Complexity : O(k)
# Did this code successfully run on leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def maxSumAfterPartitioning(self, A, k):
        
        L = len(A)
        memo  = [ 0 for _ in range(k) ]
        
        for i in range(L-1,-1,-1):
            m, best  =  0, 0
            for j in range(i,min(L,i+k)):
                if A[j] > m:
                    m  = A[j]
                s  =  (j-i+1)*m + memo[(j+1)%k]
                if s > best:
                    best  =  s
            memo[i%k] = best
        return memo[0]