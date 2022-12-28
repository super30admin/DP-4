import numpy as np
class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:

        size = len(arr)
        dp = np.zeros(size)
        dp[0] = arr[0]
        
        for i in range(1, size):
            max_sub = 0
            for j in range(1, k+1):
                if i-j >= -1:
                    if i-j < 0:
                        max_n = max(arr[i::-1])
                    else:    
                        max_n = max(arr[i:i-j:-1])
                    max_n = max_n * j + dp[i-j]
                    max_sub = max(max_sub, max_n)
            dp[i] = max_sub
        
        return int(dp[len(dp)-1])
