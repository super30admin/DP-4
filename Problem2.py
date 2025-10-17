"""
TC: O(N*K) The time complexity is dominated by the nested loops. The outer loop runs N times, and the inner loop runs at most K times.
SC: O(N) The space complexity is linear due to the auxiliary DP array used to store intermediate results.

Approach:

This problem is solved using Dynamic Programming (DP). The goal is to find the maximum sum obtainable after partitioning the array arr into subarrays, each of length at most k, and replacing the elements of each subarray with its maximum value.

The dp array is defined such that dp[i] represents the maximum sum achievable for the prefix of the array ending at index i (i.e., arr[0...i]).

1. Initialization: dp[0] is initialized to arr[0].
2. DP Transition: We iterate from i=1 to N-1 to compute dp[i]. For each index i, we consider all possible ending subarrays of length L where $1 \le L \le k$. The inner loop iterates backwards from the start of the possible subarray up to index i. We find the maximum element (maxi) in the current subarray arr[j...i]. The total sum for this partition choice is: maxi times length plus the max sum of the prefix ending at j-1. The transition is: $\text{dp}[i] = \max(\text{dp}[i], (\text{maxi} \times \text{length}) + \text{dp}[j-1])$. The term $\text{dp}[j-1]$ is 0 if $j=0$.

This transition ensures that for every index i, we take the maximum sum over all possible valid partitions of the final subarray of length up to k. The final result is stored in $\text{dp}[-1]$.

The problem ran successfully on LeetCode.
"""

class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        dp = [0] * len(arr)
        dp[0] = arr[0]

        for i in range(1, len(arr)):
            maxi = 0
            start = max(0, i - k + 1)

            #reverse loop
            for j in range(i, start - 1, -1):

                maxi = max(maxi, arr[j])
                length = i - j + 1
                curr_sum = maxi * length
                dp[i] = max(dp[i], curr_sum + (dp[j - 1] if j > 0 else 0))
            
        return dp[-1]
