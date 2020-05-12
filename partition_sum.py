"""
// Time Complexity : O(n * K)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
Algorithm Explanation
Given below
"""

class Solution:
    def maxSumAfterPartitioning(self, A: List[int], K: int) -> int:
        """
        Idea is that a element can be part of partition of 1 upto k and the naive approach where you consider all possible partitions for a element will have overlapping subproblems ie already computed partition sum -> motivates DP approach where each index of the dp array will constitute to maximum sum considering the element with all possible partitions upto k
        
        Algorithm
        - Initial configuration - dp[0] = A[0]
        - max_val = 0
        - Iterate over the array A from 1 to n
            - Iterate from j = i to K and j <= i + 1
                - Get the current_max = max(max_val,A[i-j+1])
                - Update the dp[i]
                    - if i >= j 
                        dp[i] = max(dp[i],dp[i-j] + max * j)
                    else
                        dp[i] = max(dp[i], max * j)
    
        - return dp[A.length-1]
        """
        
        dp = [0]*len(A)
        dp[0] = A[0]
        
        for i in range(1,len(A)):
            j = 1
            max_val = 0
            while j <= K and j <= i + 1:
                max_val = max(max_val,A[i-j+1])
                if i >= j:
                    dp[i] = max(dp[i],dp[i-j] + max_val * j)
                else:
                    dp[i] = max(dp[i], max_val * j)
                j+=1
        return dp[len(A)-1]