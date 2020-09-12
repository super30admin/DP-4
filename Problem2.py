#Time complexity - O(n*k) 
#Space complexity - O(n)
#Works on leetcode - yes
#Approach - The idea here is for each new element, we look back upto k elements in array and keep track of the maximum
#in that segment. We get the segment sum, once we have the maximum for this segment when we either reack k back or the start
#of array. 

class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        n = len(arr)
        dp = [0]*(n+1)
        for i in range(n):
            curmax = 0
            for j in range(1,min(k,i+1)+1):
                curmax = max(curmax, arr[i-j+1])
                dp[i] = max(dp[i], dp[i-j]+curmax*j)
        return dp[n-1]