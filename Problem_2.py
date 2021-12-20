class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        if arr == None or len(arr) == 0:
            return 0
        dp = [0] * len(arr)
        dp[0] = arr[0]
        
        for i in range(1, len(arr)):
            maximum = arr[i]
            for j in range(1, k+1):
                if i-j+1 >= 0:
                    maximum = max(maximum, arr[i-j + 1])
                    if i-j >= 0:
                        dp[i] = max(dp[i], dp[i-j] + maximum * j)
                    else:
                        dp[i] = max(dp[i], maximum * j)
        return dp[len(arr)-1]

# Time Complexity : O(n*k)
# Space Complexity: O(n)