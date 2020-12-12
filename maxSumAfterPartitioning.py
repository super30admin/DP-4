"""
TC=0(N*K)
SC=O(N)


"""

class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        if arr is None or len(arr)==0:
            return 0
        N=len(arr)
        dp=[0]*(N)
        for i in range(N):
            max1=arr[i]
            for j in range(1,k+1):#no of elements in partion, single ,double,...k
                if(i-j+1>=0):
                    max1=max(max1,arr[i-j+1]) # max of prevmax and new incoming element
                    if(i-j>=0):
                        dp[i]=max(dp[i-j]+max1*j,dp[i])
                    else:
                        dp[i]=max(max1*j,dp[i])
        return dp[N-1]
                    
            