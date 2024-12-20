# Approach:
# This problem can be solved using dynamic programming. We can define a dp array where dp[i] 
# represents the maximum sum we can achieve by partitioning the subarray arr[0...i].
# 1. For each element arr[i], consider partitioning the subarray ending at index i into subarrays 
#    of length from 1 to k.
# 2. For each partition, the subarray values are changed to the maximum value of that subarray.
# 3. Calculate the maximum sum for each partition and update the dp array.
# 4. The answer will be stored in dp[len(arr) - 1], which will give the largest sum after partitioning.

# Time Complexity: O(n * k), where n is the length of the array, and k is the maximum subarray length.
# Space Complexity: O(n), where n is the length of the array for the dp array.
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        n = len(arr)
        
        # Initialize dp array where dp[i] represents the maximum sum for arr[0...i]
        dp = [0] * n
        
        for i in range(n):
            max_val = 0  # To store the max value in the current subarray
            
            # Try all possible subarray lengths from 1 to k
            for j in range(1, min(k, i + 1) + 1):
                max_val = max(max_val, arr[i - j + 1])  # Update the max value in the subarray
                # Update dp[i] by taking the best partitioning option
                dp[i] = max(dp[i], (dp[i - j] if i - j >= 0 else 0) + max_val * j)
        
        # The answer is stored in dp[n-1], which is the max sum for the entire array
        return dp[n - 1]
