class Solution:
    # dp : bottom up approach
    # TC: O(nk)
    # SC: O(n)
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        if arr is None or k==0:
            return sum(arr)
        n = len(arr)
        dp = [0]*(n+1)
        
        
        for i in range(1, n + 1):
            max_val = 0
            for j in range(1, min(k, i) + 1): 
                max_val = max(max_val, arr[i - j])
                dp[i] = max(dp[i], dp[i - j] + max_val * j)
        print(dp)
        return dp[n]