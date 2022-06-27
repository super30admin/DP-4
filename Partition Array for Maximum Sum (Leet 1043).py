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


# using reverse for loop

class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        n = len(arr)
        
        dp = [0 for x in range(n)]
        
        for i in range(len(arr)):
            ma = 0
            count = 0
            for j in range(i,-1,-1):
                if j >= 0 and count < k:
                    ma = max(ma, arr[j])
                    if j-1 >= 0:
                        dp[i] = max(dp[i],(ma*(count+1) + dp[j-1]))
                    else:
                        dp[i] = max(dp[i],(ma*(count+1)))
                count += 1
        return dp[n-1]