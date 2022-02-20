#Time Complexity O(N)
#Space Complexity O(N)
from typing import List

class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:

        dp = [0]*len(arr)
        dp[0] = arr[0]
        maxv = 0

        for i in range(1, len(dp)):
            maxv = dp[i]

            for j in range(1, k+1):

                if(i - j + 1 >= 0):

                    maxv = max(maxv, arr[i-j+1])

                    if i-j >= 0:
                        dp[i] = max(dp[i], dp[i-j] + (maxv * j))

                    else:
                        dp[i] = max(dp[i], maxv*j)

        return dp[-1]
