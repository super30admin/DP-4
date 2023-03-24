#Time Complexity :- O(nk)
#Space Complexity :- O(n)

class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        dp = []
        
        for i in range(len(arr)):
            dp.append(0)
        dp[0] = arr[0]
        maxValue = 0
        for i in range(1,len(arr)):
           maxValue = dp[i]
           for j in range(1,k+1):
                if i-j+1 < 0:
                    continue
                maxValue = max(maxValue, arr[i-j+1])
                if i - j >= 0:
                    dp[i] = max(dp[i], maxValue * j + dp[i-j])
                else:
                    dp[i] = max(dp[i], maxValue * j)
        return dp[-1]
                
                