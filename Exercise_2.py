# S30 Problem # Partition Array for Maximum Sum
#LeetCode #1043 https://leetcode.com/problems/partition-array-for-maximum-sum/description/

# Author : Akaash Trivedi
# Time Complexity : O(n*k)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode :  Yes #
# Any problem you faced while coding this : No

# can have k partition, so explore all the k, store the max value from those k combintaions (if k=3, then try max(k=1,k=2,k=3))
# take i as partition and j as length of partition and dp[i-j] will give remaining subproblem 
# For each position i, we try all possible partition lengths j from 1 to min(k, i+1)
# dp = max (dp[i] or max_element * partition_length + dp[i-j] (previous subproblem))
# *building all sultions incrementally, and for each position, try all the valid partition size ending at that partititon 
class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        l = len(arr)
        dp = [0 for _ in range(l)]
        for i in range(l):
            mx = arr[i] # setting the current as initial max
            # Try all possible partition lengths from 1 to min(k, i+1)
            #for j in range(1, k and i-j + 1 >= 0, 1):
            for j in range(1, min(k, i+1) + 1):
                # elements arr[i-j+1] to arr[i] (current partition)
                curr = arr[i-j+1]
                mx = max(mx, curr) # maximum element in this partition
                if i - j >= 0: # If there's a previous subproblem (bound check)
                    ## max_element * partition length + dp[i-j] (previous subproblem)
                    dp[i] = max(dp[i], mx*j + dp[i-j])
                else: # this is first partition (j < o)
                    # maximum element * lenght of current partition (i.e only current value)
                    dp[i] = max(dp[i], mx * j)
        return dp[l-1]