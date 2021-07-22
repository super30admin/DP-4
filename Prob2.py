class Solution(object):
    def maxSumAfterPartitioning(self, arr, k):
        """
        :type arr: List[int]
        :type k: int
        :rtype: int
        """
        #time complexity: O(kn)
        #Space complexity: O(n)
        dp = [0 for x in xrange(len(arr))]
        dp[0] = arr[0]
        
        for i in xrange(1,len(arr)):
            #incoming element is max because only one element
            maxElAtIdx = arr[i]
            #loop through different k combinations
            for j in xrange(1,k+1):
                #if it goes out of bound, break
                if i-j+1<0:
                    break
                # new incoming element is checked if it is greater than current partition created
                maxElAtIdx = max(maxElAtIdx,arr[i-j+1])
                # if partition starts from, then else condition, otherwise if
                if i-j>=0:
                    dp[i]=max(dp[i],dp[i-j]+maxElAtIdx*j)
                else:
                    dp[i]=max(dp[i],maxElAtIdx*j)
        return dp[-1]
