#Time Complexity : O(M*N), M and N begin the length of array and k
#Space Complexity : O(M*N), M and N begin the length of array and k
#Did this code successfully run on Leetcode : Yes.
#Any problem you faced while coding this : Took a while to code it.
'''Using dynamic programming, create a dp array and traverse the array while keeping
track of the best solution for the array so far. Will consider the split and not 
split choices.
'''
class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        #initialize dp array
        dp=[[0 for i in range(len(arr)+1)] for j in range(k)]
        #initialize the array to keep track of the max of col of dp. 
        prev_maximum=[0]
        for i in range(1,len(arr)+1):
            add=[]
            #for each col of dp, obtain the rows of dp. 
            for j in range(k):
                # dp values is the addition of the maximum of a previous col and 
                #the sum of the previous number of values * maximum in arr.
                if i<k and i-j<=0:
                    dp[j][i]=max(arr[0:i])*(i)
                    add.append(dp[j][i])
                else:
                    if j==0:
                        dp[j][i]=arr[i-1]
                    else:
                        dp[j][i]=max(arr[i-1-j:i])*(j+1)
                    dp[j][i]=prev_maximum[len(prev_maximum)-1-j]+dp[j][i]
                    add.append(dp[j][i])
            prev_maximum.append(max(add))
        #return the last maximum
        return prev_maximum[len(prev_maximum)-1]