'''
T = O(nk)
S =O(n)

Approach:
Identify the subproblem as the repeating partition in every choice.
Build the DP array and return the last element.
'''

class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        if not arr:
            return 0
        
        dp = [0] * len(arr)
        
        for i in range(len(arr)):
            maxx = dp[i]
            for j in range(1,k+1):
                if i-j+1 >= 0:
                    maxx = max(maxx,arr[i-j+1])
                    if i - j >= 0:
                        dp[i] = max(dp[i],maxx*j + dp[i-j])
                    else:
                        dp[i] = max(dp[i],maxx*j)
        return dp[-1]