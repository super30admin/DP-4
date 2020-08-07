------------------------Maximum Sum after Partitioning--------------------------------------------

# Time Complexity : O(N**K) as K is the range of elements we can take 
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Here we will use dp array and first check the previous split maximum sum. At the first element we will, caluculate the 
#maximum element as element and continue to check previous windows until K. We can access the start element with i-j+1,
# and reach the previous maximum sum at i-j index at every index.

class Solution:
    def maxSumAfterPartitioning(self, A: List[int], K: int) -> int:
        if not A:
            return 0
        
        dp = [0 for i in range(len(A))]
        for i in range(0, len(A)):
            m = A[i]
            j = 1
            while j<=K and (i-j+1)>=0:
                m = max(m, A[i-j+1])
                if i >= j:
                    dp[i] = max(dp[i], dp[i-j]+m*j)
                else:
                    dp[i] = max(dp[i], m*j)
                j +=1
        return dp[-1]