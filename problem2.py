#time O(N)
#space O(N)

class Solution:
    def maxSumAfterPartitioning(self, A: List[int], K: int) -> int:
        n=len(A)
        dp=[0]*n
        dp[0]=A[0]
        maxi=A[0]
        for i in range(1,K):
            maxi=max(maxi,A[i])
            dp[i]=maxi*(i+1)
        for i in range(K,n):
            maxi1=A[i]
            for j in range(1,K+1):
                maxi1=max(maxi1,A[i-j+1])
                dp[i]=max(dp[i],dp[i-j]+maxi1*j)
        # print(dp)
        return dp[n-1]
        #see video happygrlzt
        # N = len(A)
        # dp = [0] * (N + 1)
        # for i in range(N):
        #     curMax = 0
        #     for k in range(1, min(K, i + 1) + 1):
        #         curMax = max(curMax, A[i - k + 1])
        #         dp[i] = max(dp[i], dp[i - k] + curMax * k)
        #     print(dp)
        # return dp[N - 1]
        
                
            
            