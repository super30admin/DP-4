# // Time Complexity : O(Kn)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach

class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        #edge
        if arr == None or len(arr) == 0:
            return 0
        dp = [0 for i in range(len(arr))]
        #first Element remains the same
        dp[0] = arr[0]
        for i in range(1, len(dp)):
            #at each index, we are exploring all the possible partition that we can put
            maxi = arr[i]
            #Start Parttition
            for j in range(1, k + 1):
                if i - j + 1 >= 0:
                    #Compare the incoming elements with the earlier maximum
                    maxi = max(maxi, arr[i - j + 1])
                    if i - j >= 0:
                        dp[i] = max(dp[i], dp[i - j] + maxi * j)
                    else:
                        dp[i] = max(dp[i], maxi * j)

        return dp[len(arr) - 1]


