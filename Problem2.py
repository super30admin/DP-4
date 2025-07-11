"""
I used bottom-up dynamic programming to solve the problem. For each index `i`, I try all partition sizes `j` from 1 to `k`, and calculate the maximum sum by choosing the largest element in the partition and multiplying it by `j`. I store the best result in `dp[i]` by comparing all such partition options.
Time Complexity: O(n * k)
Space Complexity: O(n)
"""
class Solution:
    def maxSumAfterPartitioning(self, arr: list[int], k: int) -> int:
        
        n = len(arr)
        dp = [0] * n
        dp[0] = arr[0]

        for i in range(1, n):
            max_in_partition = arr[i]
            for j in range(1, min(k, i + 1) + 1):
                max_in_partition = max(max_in_partition, arr[i - j + 1])
                curr_sum = max_in_partition * j

                if i - j >= 0:
                    curr_sum += dp[i - j]
                dp[i] = max(dp[i], curr_sum)

        return dp[-1]