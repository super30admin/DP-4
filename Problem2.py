#time Complexity: O(nk)
#Space complexity is: O(n)
#Code ran successfully on leetcode
#No issues faced while coding
class Solution(object):
    def maxSumAfterPartitioning(self, arr, k):
        """
        :type arr: List[int]
        :type k: int
        :rtype: int
        """
        #Base case
        if(arr==None or len(arr)==0):
            return 0
        #initializing all the required variables
        n=len(arr)
        dp=[0 for i in range(n)]
        dp[0]=arr[0]
        #looping through the given array
        for i in range(1,n):
            #initially taking the maximum value as the arr[i]
            maxi=arr[i]
            for j in range(1,k+1):
                #Making sure that there are k value to the backward
                if i - j + 1 >= 0:
                    #finding the maximum value in the partition
                    maxi=max(maxi,arr[i-j+1])
                    #Making sure that we are not going out of bounds
                    if(i-j>=0):
                        #We are calcuating the maximum value for the dp[i]
                        dp[i]=max(dp[i],j*maxi+dp[i-j])
                    else:
                        #If i-j is less than 0, below one will be the condition
                        dp[i]=max(dp[i],j*maxi)
        #FInally we are returning the optimized value
        return dp[n-1]

