#1043. Partition Array for Maximum Sum
#Time Complexity is O(nk)   
#Space Complexity is O(n) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
class Solution:
    def maxSumAfterPartitioning(self, A: List[int], K: int) -> int:
        if not A or len(A) == 0:
            return 0
        dp = [0] * len(A)
        for i in range(len(A)):
            maxv = A[i]
            for j in range(K):
                if i - j >= 0:
                    maxv = max(maxv, A[i-j])
                    if (i-j-1) >= 0:
                        dp[i] = max(dp[i], dp[i-j-1] + maxv * (j+1))
                    
                    else:
                        dp[i] = max(dp[i],  maxv * (j+1))
        return dp[-1]