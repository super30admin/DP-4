# Time Complexity :O(n * k)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode :yes
from ast import List


class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        n = len(arr)
        dp = [0] * n

        for i in range(n):
            max_val = arr[i]
            for j in range(1, k + 1):  
                if i - j + 1 >= 0:
                    max_val = max(max_val, arr[i - j + 1])
                    currVal = j * max_val
                    if i - j >= 0:
                        currVal = dp[i - j] + j * max_val
                    dp[i] = max(dp[i], currVal)

        return dp[n - 1]
