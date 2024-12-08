#TC: O(n*k)
#SC: O(n)
class Solution(object):
    def maxSumAfterPartitioning(self, arr, k):
        """
        :type arr: List[int]
        :type k: int
        :rtype: int
        """
        n = len(arr)
        #Assign dp matrix with all 0's initially, we take n+1 to avoid indexing issues
        dp = [0] *(n+1)
        #print(dp)
        #First element will have it's own value as only 1 partition is possible
        #Start Iterating from second element in the array
        for i in range(1,n+1):
            maxx = 0
            maxsum = 0
            for j in range(1,k+1):
                if i - j >= 0:
                    maxx = max(maxx, arr[i-j]) #keep calculating the max in that partition
                    maxsum = max(maxsum, dp[i-j] + maxx*j) #keep updating max sum to be sum of prev dp before partition and j times the max number in that partition
            dp[i] = maxsum
        return dp[n] # the last element will be our answer