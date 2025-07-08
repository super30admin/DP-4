"""
dp[i] be the maximum sum for subarray ending at index i
For each index i, try all partition lengths 1 to k, and choose the one maximizing:
dp[i] = max(dp[i-j] + maxVal * j)
Use rolling max in each partition to calculate value
"""
"""
Time Complexity - O(n × k)
Space Complexity - O(n) for DP array
"""

class partitionMaxArray:
    def maxSumAfterPartitioning(self, arr: list[int], k: int) -> int:
        n = len(arr)
        dp = [0] * (n + 1)

        for i in range(1, n + 1):
            max_val = 0
            for j in range(1, min(k, i) + 1):
                max_val = max(max_val, arr[i - j])
                dp[i] = max(dp[i], dp[i - j] + max_val * j)

        return dp[n]
    
if __name__ == "__main__":
    arr = [1,15,7,9,2,5,10]
    k = 3
    obj = partitionMaxArray()
    print(obj.maxSumAfterPartitioning(arr, k))
