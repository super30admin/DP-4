class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:

        #Method 1 - Brute force is exhaustive. 
        #At each element, calculate parititons upto len k and get max. -> TC K^n.

        #Method 2 - DP - O(n) SC and TC
        n=len(arr)
        dp=[0]*n
        dp[0]=arr[0]

        for i in range(1,n):
            currmax=arr[i] #this is need to get max in current paritions, so just set 1st element in the current paritition to be the max and then find the actual max.
            for j in range(1,k+1): #k different partitions
               if i-j+1>= 0: #this is needed to take care of lower bounds. 
                currmax=max(currmax,arr[i-j+1]) #get max in my current partition
                if i-j>=0:
                    dp[i]=max(dp[i],j*currmax+dp[i-j]) #j partitions X current max in my current partition+dp[i-j] if dp[i-j] exists.
                else:
                    dp[i]=max(dp[i],j*currmax)
        return dp[-1]
