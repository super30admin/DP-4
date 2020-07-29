# Time complexity - O(n * k) -- from every location, we look k steps back. worst case O(n^2)
# Space complexity - O(n) --extra space to save the solution at every location.
# Did this code successfully run on leetcode? - yes

class Solution:
    def maxSumAfterPartitioning(self, A: List[int], K: int) -> int:
        # length of array A
        n = len(A)
        dp = [0] * n
        
        for i in range(n):
            maxn = A[i]         # keep a running max at every step
            for j in range(K):  # look k steps back to find the maximum partition length
                if (i-j) >= 0:  
                    maxn = max(maxn, A[i-j])    
                    if (i-j-1) >= 0:    # partition into 1...k at every location
                        dp[i] = max(dp[i], dp[i-j-1] + maxn * (j+1)) 
                    else:
                        dp[i] = max(dp[i],  maxn * (j+1))
        
        return dp[-1]
        