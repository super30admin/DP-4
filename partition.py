#Time Complexity: O(nk)
#Space Complexity: O(n)
class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        dp = [0]*(len(arr))
        dp[0] = arr[0]
        
        for i in range(1,len(arr)):
            maxm = arr[i]
            for j in range(i,i-k,-1):
                
                if j>=0:
                    maxm = max(maxm,arr[j])

                    if j -1 >= 0:
                        dp[i] = max(dp[i], (maxm*(i-j+1))+dp[j-1])

                    else:
                        dp[i] = max(dp[i], (maxm*(i-j+1)))
                    
        return dp[-1]
