class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        
        
        if not arr:
            return 0
        
        dp = [0] *(len(arr))
        
        
        for i in range(len(arr)):
            currMax = arr[i]
            for j in range(1, k+1):
                if i-j+1>=0:
                    currMax = max(currMax, arr[i-j+1])
                    if i-j>=0:
                        dp[i] = max(dp[i],dp[i-j]+currMax*j)
                    else:
                         dp[i] = max(dp[i],currMax*j)
        print(dp)
        return dp[-1]
    
    Time: O(N*K)
    Space: O(N)
  
