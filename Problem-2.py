class Solution(object):
    def maxSumAfterPartitioning(self, arr, k):
        """
        :type arr: List[int]
        :type k: int
        :rtype: int
        """
        n = len(arr)
        dp = [0] * n

        dp[0] = arr[0]
        
        for i in range(1,n):
            currMax = arr[i]
            for j in range(1,k+1):
                if(i-j+1>=0):
                    currMax = max(currMax,arr[i-j+1])
                    if(i-j>=0):
                        dp[i] = max(dp[i],currMax * j + dp[i-j])
                    else:
                        dp[i] = max(dp[i],currMax * j)

        return dp[n-1]
        