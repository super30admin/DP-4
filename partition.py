# // Time Complexity :O(nk)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No

# we create a dp array with the best possible sum of partitions till there. we are storing the subproblems-value in the array so that we need not recalculate it everytime.
# instead we use prev values in the dp array to get the best possible value at any point. 
class Solution(object):
    def maxSumAfterPartitioning(self, arr, k):
        """
        :type arr: List[int]
        :type k: int
        :rtype: int
        """
        # O(nk)
        n=len(arr)
        dp=[0] * n
        dp[0]=arr[0]
        for i in range(1,n):
            maxel=arr[i]
            for j in range(1,k+1):
                if(i-j+1>=0):
                    maxel=max(maxel,arr[i-j+1])
                    # curr=partition value+value of remaining subproblem
                    
                    if(i-j>=0):
                        curr=maxel*j + dp[i-j]
                    else:
                        curr=maxel*j
                    dp[i]=max(dp[i],curr)
        return dp[n-1]