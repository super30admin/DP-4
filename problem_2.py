# 1043. Partition Array for Maximum Sum

# Appraoch: Dp-> Keep calculating the max at every index (at most for k subbbary's(from prev) at each index)

# Code:

class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        if not arr:
            return 0
        dp =[0 for i in range(len(arr))]
        
        for i in range(len(arr)):
            maxx = float('-inf')
            
            for j in range(1, k+1):
                if (i-j+1)>=0:
                    maxx = max(maxx, arr[i-j+1])
                    
                    if i>=j:
                        dp[i] = max(dp[i], dp[i-j]+maxx*j)
                    else:
                        dp[i] = max(dp[i], maxx*j)
        
        return dp[-1]

# Time Complexity: O(N*k)
# Space Complexity: O(N)
# Accepted on Leetcode: YES!