# Time Complexity: O(n)
# Space Complexity: O(n)
# Ran on Leetcode: Yes

class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        dp = [0 for _ in range(len(arr))]
        for i in range(len(arr)):
            j = 1
            m = arr[i]
            while j<=k and i-j+1>=0:
                m = max(arr[i-j+1],m)
                if i-j>=0:
                    dp[i] = max(dp[i], dp[i-j]+m*j)
                else:
                    dp[i] = max(dp[i],m*j)
                    
                j += 1
        return dp.pop()
        