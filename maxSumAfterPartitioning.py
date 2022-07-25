class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        dp =[0]*len(arr)
        dp[0] = arr[0]
        curr_max = 0
        
        for i in range(len(arr)):
            if i < k:
                curr_max = max(curr_max,arr[i])
                dp[i] = (i+1) * curr_max
            else:
                curr_max = 0
                for j in range(1,k+1):
                    curr_max = max(curr_max, arr[i-j+1])
                    curr_sum = j * curr_max + dp[i-j]
                    dp[i] = max(dp[i],curr_sum)
        
        return dp[-1]
