# Time Complexity : O(n*k)
# Space Complexity : O(n)
# Approach : Dynamic Programming
# The idea is that at each index i, we can partition the array into a maximum of k parts.
# We can either make the partition at the ith index, or at maximum k-1 indices before it.
# We can use a dynamic programming array to store the maximum sum at each index.
# We can iterate through the array and for each index i, we can iterate through the k indices before it.
# We can find the maximum value in the k indices before it and multiply it by the number of indices we are partitioning.
# We can then add the maximum sum at the index i-k to the current index.
# We can then return the maximum sum at the last index of the array.
class Solution:
    def maxSumAfterPartitioning(self, arr, k):
        # Calculate the length of the array
        n = len(arr)
        # Initialize a DP array to store the maximum sum at each index
        dp = [0] * n
        # Initialize a variable to store the current maximum value
        currMax = 0
        # Iterate through the array
        for i in range(n):
            # Iterate through the k indices before the current index
            for j in range(1, k+1):
                # If we are at an index less than k, we cannot go back k indices
                if i-j+1 >= 0:
                    # Find the maximum value in the k indices before the current index
                    currMax = max(currMax, arr[i-j+1])
                    # Calculate the maximum sum at the current index
                    if i-j >= 0:
                        dp[i] = max(dp[i], currMax*j+dp[i-j])
                    # If we are at the first index, we cannot go back
                    # So we can just multiply the maximum value by the number of indices we are partitioning
                    else:
                        dp[i] = max(dp[i], currMax*j)
            # Reset the current maximum value for the next iteration
            currMax = 0
        # Return the maximum sum at the last index of the array
        return dp[n-1]