#I created a dp array where dp[i] represents the maximum sum achievable by partitioning the first i elements. For each element in arr, I considered all possible partition sizes from 1 to k. I tracked the maximum value within the current partition and updated dp[i] with the best sum achievable by adding the product of this maximum value and the partition size to the previously computed maximum sums. This ensures optimal partitioning for maximum sum. The solution has a time complexity of O(n⋅k) and a space complexity of O(n).

class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:

        n = len(arr)
        dp = [0] * (n + 1)
        for i in range(1, n + 1):
            max_val = 0
            for j in range(1, min(k, i) + 1):
                max_val = max(max_val, arr[i - j])
                dp[i] = max(dp[i], dp[i - j] + max_val * j)

        return dp[n]
        