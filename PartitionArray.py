"""
Given an integer array arr, partition the array into (contiguous) subarrays of length at most k. 
After partitioning, each subarray has their values changed to become the maximum value of that subarray.

Return the largest sum of the given array after partitioning. 
Test cases are generated so that the answer fits in a 32-bit integer.
"""

# Time Complexity : O(n * k) where n is len of arr
# Space Complexity : O(n)
# Did this code successfully run on VScode : Yes
# Any problem you faced while coding this : No

from typing import List

class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        
        dp = [0]*len(arr)
        dp[0] = arr[0]
        maxv = 0
        
        for i in range(1, len(dp)):
            maxv = dp[i]
            
            for j in range(1, k+1):
                
                if(i - j + 1 >= 0):
                    
                    maxv = max(maxv, arr[i-j+1])
                    
                    if i-j >= 0:
                        dp[i] = max(dp[i], dp[i-j] + (maxv * j))
                        
                    else:
                        dp[i] = max(dp[i], maxv*j)
                        
        return dp[-1]
            