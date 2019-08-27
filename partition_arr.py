"""
Time: O(n*k)
Space : O(n)
Leet: Accepted
Problems: Could not come up with the solution myself, referred to code provided after lecture
"""

class Solution(object):
    def maxSumAfterPartitioning(self, A, K):
        """
        :type A: List[int]
        :type K: int
        :rtype: int
        """
        dp = [0] * (len(A)+1) #each element of dp array stores max up to that point
        dp[1] = A[0]

        for i in range(1,len(A)):
            currMax = A[i] #initialize currMax with the element we are finding maximum up to
            for j in range(1,K+1): #windows of different sizes upto K
                start_idx = i - j + 1 #find start index if window of that size was applied
                if start_idx<0:
                    break
                currMax = max(currMax,A[start_idx])
                dp[i+1] = max(dp[i+1],dp[start_idx]+currMax*j) #update
        return dp[-1]
