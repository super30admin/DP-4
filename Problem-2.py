# Time Complexity : O(n * k), n = len(arr)
# Space Complexity : O(n), for the DP array storing max sum till index i
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# 1. Use dynamic programming to track the maximum sum up to each index.
# 2. For each position, consider all subarrays ending at i with length <= k.
# 3. Update the DP value as max(dp[i], dp[i-j] + max(arr[i-j+1:i+1]) * j) for all j.

from typing import List

class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        n = len(arr)
        dp = [0] * n
        
        for i in range(n):
            max_val = 0
            for j in range(1, min(k, i+1) + 1):
                max_val = max(max_val, arr[i - j + 1])
                if i >= j:
                    dp[i] = max(dp[i], dp[i - j] + max_val * j)
                else:
                    dp[i] = max(dp[i], max_val * j)
        
        return dp[-1]