#Time Complexity: O(nk)
#Space Complexity: O(n)
class Solution(object):
    def maxSumAfterPartitioning(self, arr, k):
        """
        :type arr: List[int]
        :type k: int
        :rtype: int
        """
        dp = [0 for x in range(len(arr))]
        dp[0] = arr[0]
        for i in range(len(dp)):
            maxx = dp[i]
            for j in range(1, k+1):
                if i -j +1 >= 0:
                    maxx = max(maxx, arr[i-j+1])
                    if i - j >= 0:
                        dp[i] = max(dp[i], dp[i-j]+maxx*j)
                    else:
                        dp[i] = max(dp[i], maxx*j)
        return dp[-1]