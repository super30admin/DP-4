class Solution:
    def maxSumAfterPartitioning(self, A: List[int], K: int) -> int:
        if A==None or len(A)==0:
            return 0
        n=len(A)
        max1=0
        dp=[0]*n
        for i in range(0,n):
            max1=A[i]
            j=1
            while i-j+1>=0 and j<=K:
                max1=max(max1,A[i-j+1])
                if i>=j:
                    dp[i]=max(dp[i],dp[i-j]+max1*j)
                else:
                    dp[i]=max(dp[i],max1*j)
                    
                j+=1
        return dp[len(dp)-1]
        
                
        
