
# Time Complexity - O(n)
# Space Complexity- O(n)

class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        n = len(arr)
        dp = [0] * n
        
        for i in range(n):
            # Find the maximum value within the current partition
            maxVal = arr[i]
            for j in range(1, k+1):
                if i-j+1 >= 0:
                    maxVal = max(maxVal, arr[i-j+1])
                    # maximum sum for the current partition
                    if i-j >= 0:
                        dp[i] = max(dp[i], j*maxVal + dp[i-j])
                    else: 
                        dp[i] = max(dp[i], j*maxVal)
        
        return dp[n-1]
