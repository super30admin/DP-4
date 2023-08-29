# Time Complexity:  O(n * k) 
# Space Complexity: O(n)
class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        n = len(arr)
        dp = [0] * (n + 1)
        
        for i in range(1, n + 1):
            max_val = float('-inf')
            for j in range(1, min(k, i) + 1):
                max_val = max(max_val, arr[i - j])
                dp[i] = max(dp[i], dp[i - j] + max_val * j)
                
        return dp[n]
