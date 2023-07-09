#Time Complexity:O(n)
#Space Complexity:O(n)

class Solution(object):
    def maxSumAfterPartitioning(self, arr, k):
        """
        :type arr: List[int]
        :type k: int
        :rtype: int
        """
        n=len(arr)
        dp=[0 for i in range(n+1)]
        dp[n]=0
        
        for i in range(n-1,-1,-1):
            length=0
            maxi=-1e9
            maxAns=0
            for j in range(i,min(i+k,n),1):
                length+=1
                maxi=max(maxi,arr[j])
                Sum=length*maxi+dp[j+1]
                maxAns=max(maxAns,Sum)
            dp[i]=maxAns
            
        return dp[0]