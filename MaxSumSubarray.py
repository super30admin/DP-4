class Solution(object):
    def maxSumAfterPartitioning(self, arr, k):
        """
        :type arr: List[int]
        :type k: int
        :rtype: int
        """
        # trick part is to figure out how many numbers to break it to such that the parttions with in range of k can give us the max value
        # brute force we can do partitins from i to k and keep checking the sum we get in the end and compare it with the before sum and take the max until we try all the parttions, but in normal for loop and checking the recrussive approch we wil be havign overlapping checkings
        # for example we will be checking at i = 0, j be 1,2,3 we will check the max for arr(0,3), arr(1,3), arr(2,3) and whern i is 1 we again find the valu for arr(1,3), arr(2,3), arr(3,3) and so on so we have overlapping subproblems to see which parttion gives us the max sum
        # using dp to save the extra cost of calculating if we have already computed lets just use it.

        # tc : O(n*k) , sc : O(n) by hashmap 

        self.memo = {}
        return self.helper(arr, 0, k)

    def helper(self,arr,i,k):
        if i >= len(arr):
            return 0 

        if i in self.memo:
            return self.memo[i]

        maxsum = 0
        currhigh = 0

        for j in range(1,k+1):
            if i+j > len(arr):
                break
            
            currhigh = max(currhigh,arr[i+j-1])
            currval = currhigh*j + self.helper(arr, i+j, k)
            maxsum = max(maxsum, currval)

        self.memo[i] = maxsum
        return maxsum
