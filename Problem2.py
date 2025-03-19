# Problem 2 : Partition Array for Maximum Sum
# Time Complexity : 
'''
Bottom-up 1d dp array: O(nk) where n is the number of elements in array and k is the number of maximum elements allowed in partition
Memoization: O(nk) where n is the number of elements in array and k is the number of maximum elements allowed in partition
'''
# Space Complexity : 
'''
Bottom-up 1d dp array: O(n) where n is the number of elements in array
Memoization: O(n) where n is the number of elements in array
'''
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach
# tabulation ie. bottom-up 
from typing import List
class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        # initialize the dp array with the arr length and fill with 0
        dp = [0] * (len(arr))
        # set the dp[0] with the value at arr[0]
        dp[0] = arr[0]
        # loop through array from 1 to arr.length
        for i in range(1, len(arr)):
            # initialize the maxValue to 0
            maxValue = 0
            # loop from 1 to k+1
            for j in range(1, k+1):
                # check if the i-j+1 is greater than or equal to 0
                if i-j+1 >= 0:
                    # if it is then first find the max between maxValue and number at (i-j+1)th position in the array
                    maxValue = max(maxValue, arr[i-j+1])
                    # check if the (i-j) is less than 0
                    if i-j < 0:
                        # if it is then dp[i] is equal to maximum of dp[i] and maxValue*j + 0
                        dp[i] = max(dp[i], maxValue*j + 0)
                    else:
                        # else dp[i] is equal to maximum of dp[i] and maxValue*j + dp[i-j]
                        dp[i] = max(dp[i], maxValue*j + dp[i-j])
        # return the value of last element of dp array
        return dp[len(arr)-1]
    

# Memoization

class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        # initialize the memo array with the arr length and fill with -1
        memo = [-1] * len(arr)
        
        # helper function to calculate the maxSum for the partition at pivot 
        def helper(arr: List[int], k: int, pivot: int) -> int:
            # memo is a global variable
            nonlocal memo
            # if pivot is at last position in the array then resturn 0
            if pivot == len(arr): return 0
            # if the memo array has value at pivot then return that value
            if memo[pivot] != -1: return memo[pivot]
            # initialize the result and maxValue variable
            result = 0
            maxValue = 0
            # loop from pivot to the length of the array
            for i in range(pivot, len(arr)):
                # check if the i is less than pivot + k 
                if i < pivot + k:
                    # if it is find maximum value between maxValue and arr[i]
                    maxValue = max(maxValue, arr[i])
                    # calculate the current value of the partition
                    currentPartition = (i-pivot+1) * maxValue
                    # call helper function for pivot i+1
                    res = helper(arr, k, i+1)
                    # result will be maximum of result and res+currentPartition
                    result = max(result, res + currentPartition)
            # save the value of result in the memo for future use
            memo[pivot] = result
            # return the result
            return result
        # call helper function with pivot at 0
        return helper(arr, k, 0)

        

        