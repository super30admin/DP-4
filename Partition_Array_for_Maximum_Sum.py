class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        
        
        if not arr :
            return 0
        
        dp = [0]*len(arr)
        max_value = 0
        
        for i in range(len(arr)):
            max_element = arr[i]
            
            for j in range(1,k+1):
                if i-j+1 < 0:
                    break
                max_element = max(max_element,arr[i-j+1])
                if i-j >=0:
                    dp[i] = max(dp[i],dp[i-j] + max_element*j)
                else:
                    dp[i] = max(dp[i],  max_element*j )
        
        return dp[-1]
