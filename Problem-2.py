class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        if not arr or len(arr)==0:
            return 0
        
        dp=[0 for i in range(len(arr))]
        for i in range(len(dp)):
            maximum=float('-inf')
            for j in range(1,k+1):
                if i-j+1>=0:                    
                    maximum=max(maximum,arr[i-j+1])

                    if i>=j:
                        dp[i]=max(dp[i],maximum*j +dp[i-j])
                    else:
                        dp[i]=max(dp[i],maximum*j)
                    
        return dp[-1]