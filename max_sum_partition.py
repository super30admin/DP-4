#Time Complexity : O(n^2)
#Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        dp = [0]*len(arr)
        dp[0] = arr[0]
        maxval = 0
        for i in range(1, len(dp)):
            maxval = dp[i]
            for j in range(1, k+1):
                if i-j+1 >= 0:
                    maxval = max(maxval, arr[i-j+1])
                    if i-j >= 0:
                        dp[i] = max(dp[i], (maxval * j) + dp[i-j])
                    else:
                        dp[i] = max(dp[i], (maxval * j))
                    
        return dp[-1]
        
        