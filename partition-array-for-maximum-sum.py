# Recursive solution TC: O(k^n)
# DP Time Complexity: O(kn)
# Space Complexity: O(n)
class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        # Null condition check
        if len(arr) == 0 or arr == None:
            return 0
        
        # Take a dp array
        dp = [0]* len(arr)
        # Take the first element as the first element in the array
        dp[0] = arr[0]
        
        for i in range(1, len(dp)):
            # Reset the maxVal to zero after each index
            maxVal = 0
            for j in range(1, k+1):
                # Check this condition to obtain the index of element in array
                if i-j+1 >= 0:
                    # Obtain the max value by comparing with the current element in array
                    maxVal = max(maxVal, arr[i-j+1])
                    # This is when i is greater than j and equal (first and second element)
                    if i-j>=0:
                        # Keep adding the max in the dp
                        dp[i] = max(dp[i], dp[i-j] + j*maxVal)
                    else:
                        # Keep adding the max in the dp without recalculation
                        dp[i] = max(dp[i], j*maxVal)
        # return the last element in dp
        return dp[-1]