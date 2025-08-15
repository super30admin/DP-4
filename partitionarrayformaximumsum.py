# Time Complexity: O(m*n)
# Space Complexity: O(n)
class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        n = len(arr)
        dp = [0] * n
        dp[0] = arr[0]
        for i in range(1, n):
            currMax = 0
            for j in range(1, k + 1):
                if i - j + 1 < 0:
                    break
                currMax = max(currMax, arr[i - j + 1])
                if i - j >= 0:
                    dp[i] = max(dp[i], currMax * j + dp[i - j])
                else:
                    dp[i] = max(dp[i], currMax * j)
                print(dp)

        return dp[n - 1]
