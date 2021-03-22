"""
1043. Partition Array for Maximum Sum
Time Complexity - O(n)
Space Complexity - O(n)
"""
class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        dp = [0] * (len(arr) + 1)
        for i in range(1,len(arr) + 1):
            end = i - 1 
            start = max(i-1-k,-1)
            currMax = 0     
            for p in range(end, start, -1):
                currMax = max(currMax,arr[p])
                dp[i] = max(dp[i], dp[p] + currMax * (i-p))

        return dp[-1]