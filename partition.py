# Time Complexity : O(N*k) where N is the length of the array and k is the partition size
# Space Complexity : O(N) where N is the length of the array
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
# I am using to recursion with memoization to store the already calculated values
# I am using a bottom up approach to calculate the maximum sum after partitioning the array
# I am moving a window of size k and check for each window the maximum value and calculate the sum
# I am storing the calculated values in a memo array to avoid recalculating them
# This memo array is initialized with -1 to indicate that the value is not yet calculated when the value is calculated, it is stored in the memo array
# So this decreases the time complexity from exponential to linear
# Finally, I return the maximum sum after partitioning the array
from typing import List
class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        self.memo = [-1] * len(arr)
        def helper(idx):
            if idx >= len(arr):
                return 0
            if self.memo[idx] != -1:
                return self.memo[idx]
            currSum = 0
            maxSum = 0
            for i in range(1,k+1):
                if idx + i > len(arr):
                    break
                currSum = max(currSum,arr[idx + i - 1])
                currMax = currSum*i + helper(i+idx)
                # print(currSum,currMax)
                maxSum = max(maxSum,currMax)
            self.memo[idx] = maxSum
            return maxSum
        return helper(0)
            
        