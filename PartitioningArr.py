#Time : O(n*k)
#Space : O(n)

class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        
        if not arr:
            return 0
        
        dp = [0]*len(arr)
        maxVal  = 0
                
        #calculate the max with partition size rangiing from 1 to k and store maximum in dp[i]
        for i in range(len(dp)):
            maxVal = arr[i]
            for j in range(1, k+1):
                if i-j+1 >= 0:
                    maxVal = max(maxVal, arr[i-j+1])

                    if i-j>=0:
                            dp[i] = max(dp[i], maxVal*j+dp[i-j])
                    else:
                            dp[i] = max(dp[i], maxVal*j)   
                                    
                                    
        return dp[-1]
