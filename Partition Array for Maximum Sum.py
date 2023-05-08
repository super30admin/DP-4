# Time Complexity :  O(nk)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        dp = [0] * len(arr)
        dp[0] = arr[0]
        for i in range(1,len(arr)):
            m = arr[i]
            for j in range(1,k+1):
                if i-j+1 >= 0:
                    m = max(m, arr[i-j+1])
                    if i-j >= 0:
                        dp[i] = max(dp[i],(dp[i-j]+j*m))
                    else:
                        dp[i] = max(dp[i],j*m)
        return dp[len(arr)-1]
