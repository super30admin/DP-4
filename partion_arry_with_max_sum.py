class Solution(object):
    def maxSumAfterPartitioning(self, arr, k):
        if not arr:
            return 0 
        n = len(arr)
        dp = [0]*n
        for i in range(n):
            for j in range(k):
                if i-j < 0:
                    continue
                maxnum = max(arr[i-j:i+1])
                totalsum = maxnum*(j+1) if i-j == 0 else dp[i-j-1] + maxnum*(j+1)
                dp[i] = max(dp[i], totalsum)
        return dp[-1]
            
        
#Time-Complexity: O(n.k)
#Space-complexity:O(n)