'''
Time Complexity - O(n)
Space Complexity - O(n)

Works on Leetcode
'''
class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        n = len(arr)
        dp = [0 for i in range(n)] #create DP array
        dp[0] = arr[0]
        for i in range(1,n):
            maxV = 0 
            for j in range(1, k+1):
                if i-j+1 >= 0 :
                    maxV = max(maxV, arr[i-j+1]) #set max for each partition size at element i
                    currVal = j*maxV #caluclate total value of each partition
                    if i-j >=0:
                        currVal =  j*maxV + dp[i-j] 
                    dp[i] = max(dp[i], currVal) #set the max total value among the 3 partition sizes in the dp array position of that element
        return dp[n-1] #return last element of dp array as it will  have the max partition sum
 
        