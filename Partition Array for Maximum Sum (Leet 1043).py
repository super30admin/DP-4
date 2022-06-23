'''
Using bottom up approach
Time: O(nk)
Space: O(n)
'''

class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        n = len(arr)
        
        dp = [0 for x in range(n)]
        
        for i in range(len(arr)):
            ma = 0
            for j in range(1,k+1):
                if i-j+1 >= 0:
                    ma = max(ma, arr[i-j+1])
                    if i-j >= 0:
                        dp[i] = max(dp[i], (ma*j) + dp[i-j])
                    else:
                        dp[i] = max(dp[i], (ma*j))
        return dp[n-1]