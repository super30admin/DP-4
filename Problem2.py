# Time Complexity : O(Kn)
# Space Complexity : O(n)

class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        if arr == None or len(arr) == 0:
            return 0
        dp = [0 for i in range(len(arr))]
        #first element remains the same
        dp[0] = arr[0]
        for i in range(1, len(dp)):
            #at each index, we are exploring all the possible partition that we can put
            maxi = arr[i]
            #Start Partitioning
            for j in range(1, k + 1):
                if i - j + 1 >= 0:
                    #Compare the incoming elements with the earlier maximum
                    maxi = max(maxi, arr[i - j + 1])
                    if i - j >= 0:
                        dp[i] = max(dp[i], dp[i - j] + maxi * j)
                    else:
                        dp[i] = max(dp[i], maxi * j)

        return dp[len(arr) - 1]