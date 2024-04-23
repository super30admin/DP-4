# Time Complexity : O(m*n)
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
from typing import List
class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        n = len(arr)
        dp = [0]*(n+1)

        for i in range(0, n):
            currmax = arr[i]
            for j in range(1, k+1):
                if i-j+1 >= 0:
                    currmax = max(currmax,arr[i-j+1])
                    currVal = j * currmax
                    if(i-j >= 0):
                        currVal = dp[i-j] + j * currmax
                    dp[i] = max(dp[i], currVal)

        return dp[n-1]
