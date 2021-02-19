class Solution:
    
    """
    Description: Partition Array for Maximum Sum
    
    Time Complexity: O(nk)
    Space Complexity: O(n)
    
    Approach:
    - create a dp array with same size as original (0 values)
    - update the array by evaluating max value for each partition of length upto k
    - replace maximum values if the current value in subpartition is greater than previous
    - return last value of dp array as the answer
    """
    
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        
        if arr == None or len(arr) == 0: return
        
        dp = [0]*len(arr)
        
        for i in range(len(arr)):
            max_val = dp[i]
            for j in range(1, k + 1):
                if i - j + 1 >= 0:
                    max_val = max(max_val, arr[i - j + 1])
                    if i - j >= 0:
                        dp[i] = max(dp[i], dp[i - j] + max_val*j)
                    else:
                        dp[i] = max(dp[i], max_val*j)
                        
        return dp[-1]
