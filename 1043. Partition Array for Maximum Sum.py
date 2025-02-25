#space: O(n)
#time:O(1)
class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        dp=[0] * len(arr)
        dp[0]= arr[0]
        for i in range(1,len(arr)):
            me= arr[i]
            for j in range(1,k+1):
                if(i-j+1 >=0 ):
                    me= max(me, arr[i-j+1])
                    if (i-j>=0):
                        val = (me*j) + dp[i-j]
                    else:
                        val= (me*j)
                    dp[i]= max(val, dp[i])
        return dp[len(arr)-1]
        
