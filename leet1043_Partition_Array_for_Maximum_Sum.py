# Solution

# // Time Complexity : O(k*n) since for each element at the max you go back k steps and calcualte value
# // Space Complexity : O(n) DP array to save the best of the K routes for each element till then
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : None


# // Your code here along with comments explaining your approach
# Use a DP array. For each element we will have K options, either take that element only, or take the max of that and the
# previous element and multiply it twice and so on till, take the max of that element and k-1 elements before that and multiply 
# it K times. So from first element if we follow this approach and keep calculating, if we take just the first element that means
# we have partitioned it there, so rest of the value should be the addition of the best score for the previous element. If we
# take two previous elements, then max(two previous elements)*2 added to the best value for the 3rd previous element.
import math
def maxSumAfterPartitioning(arr,k):
    n = len(arr)
    dp = [-math.inf for _ in range(n)]

    for i in range(n):
        maximum = -math.inf
        for j in range(1,k+1):
            if i-j+1 < 0:
                break
            maximum = max(maximum,arr[i-j+1])
            currval = maximum*j
            if i-j >= 0:
                currval += dp[i-j]
            dp[i] = max(dp[i],currval)
    
    return dp[n-1] 

if __name__ == "__main__":
    arr = [1,15,7,9,2,5,10]
    k = 3
    print(maxSumAfterPartitioning(arr,k))