# DP Solution 
# Time Complexity = O(n * k),since grouping in max k elements
# Space Complexity = O(n)

class Solution:
    def maxSumAfterPartitioning(self, arr: list[int], k: int) -> int:
        if len(arr) == 0:
            return 0
        
        n = len(arr)
        dp = [0 for j in range(n)]
        dp[0] = arr[0]
        
        # Index of element before curr element = i - j + 1 (i.e. including element at arr[i-j+1] and curr)
       # Index for accessing the max val obtained by the previous partitions = i - j
        
        for i in range(1, n):
            maxEl = dp[i]
            for j in range(1, k+1):
                if i - j + 1 < 0:       # If at element 2 and trying to group 3 elements, i - j + 1 goes out of index
                    break
                maxEl = max(maxEl, arr[i - j + 1])      # element before the curr element (grouping)
        
                
                if i - j >= 0:
                    dp[i] = max(dp[i], maxEl * j + (dp[i - j]))
                
                # If trying to access the entered val(max) in the array for an element at index 2 and in grouping of 2 (out of bounds)
                else:
                    dp[i] = max(dp[i], maxEl * j)
    
        
        return dp[n - 1]
                