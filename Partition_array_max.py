# Time complexity : O(n)
# Space complexity : O(n)
# Leetcode : Solved and submitted

class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        if not arr:
            return 0
        
        # get the lenght of the arr
        n = len(arr)
        
        # create a dp array of size n
        dp = [0 for _ in range(n)]
        
        # copy the value of the first element as it is
        dp[0] = arr[0]
        
        # traverse the array from first element
        for i in range(1,n):
            
            # taking the max as the next element
            max_val = arr[i]
            
            # we will only check for k elements
            for j in range(1,k+1):
                # for the first case, we can go upto 2 elements, hence the condition of checking i - j + 1
                if i - j + 1 >= 0:
                    # calculate the max value out the current k elements
                    max_val = max(max_val, arr[i-j+1])
                    # multiply the k with the j, which can be the max value in the sub-array
                    currPart = max_val*j
                    
                    # add the previous dp value if we are within bounds of k values
                    if i-j >= 0:   
                        currPart = max_val*j + dp[i-j]
                # update the dp array
                dp[i] = max(dp[i], currPart)
        
        # final result is stored in the last element of the array
        return dp[n-1]
