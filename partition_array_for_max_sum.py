# Time Complexity: O(n*k)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
The code creates a dp array that contains the max possible partitioned sum till a particular index. This is gotten by 
iterating through different possibilites of partitioning the index we are in and then selecting the max to put in the dp array.
"""

class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        if arr == None or len(arr) == 0 or k == 0: return 0
        dp =[0 for i in range(len(arr))]

        for i in range(len(arr)):
            if i < k:
                dp[i] = max(arr[:i + 1]) * (i + 1)
            else:
                curr_max = 0
                for j in range(1, k + 1):
                    temp = dp[i - j] + max(arr[i - j + 1:i + 1]) * (j)
                    curr_max = max(curr_max, temp)
                dp[i] = curr_max
        
        return dp[-1]