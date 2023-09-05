from typing import List


class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        dp=[0 for i in range(len(arr))]
        dp[0] = arr[0]
        for i in range(1, len(arr)):
            maxVal = arr[i]
            for j in range(1, k+1):
                if i - j + 1 >=0 :
                    maxVal = max(maxVal, arr[i-j+1])
                    if i-j >= 0:
                        dp[i] = max(dp[i], j*maxVal+dp[i-j])
                    else:
                        dp[i] = max(dp[i],j* maxVal) 
        return dp[-1]

           