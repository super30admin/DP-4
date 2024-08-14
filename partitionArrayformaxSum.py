#// Time Complexity : O(n * k) 
# // Space Complexity : O(n) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : I saw the class vide and then didi the problem

class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        dp=[-1] * len(arr)
        def recurrFunction(ind):
            if ind==len(arr):
                return 0
            currMax=0
            currSum=0
            if dp[ind]!=-1:
                return dp[ind]
            end=min(ind+k,len(arr))
            for i in range(ind,end):
                currMax=max(currMax,arr[i])
                currSum=max(currSum,currMax*(i-ind+1)+recurrFunction(i+1))
            dp[ind]=currSum
            return currSum
        return recurrFunction(0)

# Approach:
# The problem can be solved using dynamic programming. We create a dp array of size n where n is 
# the number of elements in the array. We initialize all elements of dp array as -1. We
# define a recursive function recurrFunction which takes an index as input and returns the maximum sum
# that can be obtained by partitioning the array from the given index to the end of the array.
# In the recursive function, we iterate over the range from the given index to the end of the array
# with a step of k. For each index i in this range, we calculate the maximum sum that
# can be obtained by partitioning the array from the given index to i and adding the sum of the
# elements from i to the end of the array. We update the dp array with the maximum sum that
# can be obtained by partitioning the array from the given index to the end of the array.
# Finally, we return the maximum sum that can be obtained by partitioning the array from the first index
# to the end of the array.
