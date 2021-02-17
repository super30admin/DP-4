#Time Complexity :O(nk)
#Space Complexity :O(n) 
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this : tried running sum.
class Solution(object):
    def maxSumAfterPartitioning(self, arr, k):
        """
        :type arr: List[int]
        :type k: int
        :rtype: int
        """
        if(arr==None or len(arr)==0):
            return 0
        
        dp=[0]*len(arr)
        
        for i in range(len(arr)):
            maxi=arr[i]
            for j in range(1,k+1):
                if(i-j+1>=0):
                    #get the maxi element
                    maxi=max(maxi,arr[i-j+1])
                    if(i-j>=0):
                        dp[i]=max(dp[i],dp[i-j]+(maxi*j))
                    else:
                        #j is size of partition
                        dp[i]=max(dp[i],(maxi*j))
                
        return dp[len(arr)-1]
            