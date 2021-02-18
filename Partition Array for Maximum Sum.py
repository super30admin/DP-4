class Solution:
    #Solution 1
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        #Approach: Dynamic Programming
        #Time Complexity: O(n * k)
        #Space Complexity: O(n)
        #where, n is the length of arr
        
        dp = [None for _ in arr]
        
        for i in range(len(dp)):
            maxEl = arr[i]
            dp[i] = 0
            
            j = 1
            while j <= k and i - j + 1 >= 0:
                maxEl = max(maxEl, arr[i - j + 1])
                if i - j >= 0:
                    dp[i] = max(dp[i], dp[i - j] + maxEl * j)
                else:
                    dp[i] = max(dp[i], maxEl * j)
                
                j += 1
        
        return dp[-1]
    
    #Solution 2
    """
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        #Approach: Recursion
        #Time Complexity: O(n^k)
        #Space Complexity: O(n)     // recursion stack
        #where, n is the length of arr
        
        self.result = 0
        self.helper(arr, k, 0, 0)
        return self.result
    
    def helper(self, arr, k, idx, currSum):
        #basic
        if idx == len(arr):
            self.result = max(self.result, currSum)
            return
        
        #logic
        for i in range(idx, min(idx + k, len(arr))):
            self.helper(arr, k, i + 1, currSum + (max(arr[idx : i + 1]) * (i - idx + 1)))
    """