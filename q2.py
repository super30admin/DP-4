# Time Complexity : O(n*k), Where n are number of elements in the arr list
# Space Complexity : O(n), Where n are number of elements in the arr list
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nothing specific

from typing import List
import sys
class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        if(len(arr)==0):
            return 0
        #This is bottom top approach
        #This is base case
        dp=[arr[0]]
        
        for i in range(1,len(arr)):
            dp.append(-sys.maxsize-1)
            maxi=arr[i]
            for j in range(1,k+1):
                if(i-j+1>=0):
                    maxi=max(maxi,arr[i-j+1])
                    end=(i-j)
                    if(end>=0):
                        dp[i]=max(dp[i],(j*maxi)+dp[i-j])
                    else:
                        dp[i]=max(dp[i],maxi*j)
        #print(dp)
        return dp[-1]
        