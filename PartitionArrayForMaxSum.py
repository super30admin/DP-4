# Time Complexity : O(nxk)
# Space Complexity : O(n)

class Solution:
    def maxSumAfterPartitioning(self, arr, k):
        if not arr:
            return 0
        
        n = len(arr)
        dp = [0] * n
        dp[0] = arr[0]
        
        for i in range(1, n):
            max_val = arr[i]
            for j in range(1, min(i + 1, k) + 1):
                max_val = max(max_val, arr[i - j + 1])
                if i - j >= 0:
                    dp[i] = max(dp[i], dp[i - j] + j * max_val)
                else:
                    dp[i] = max(dp[i], j * max_val)
        
        return dp[-1]

# Examples to demonstrate the solution
solution = Solution()

# Example 1
arr1 = [1, 15, 7, 9, 2, 5, 10]
k1 = 3
print(solution.maxSumAfterPartitioning(arr1, k1))  # Output: 84

# Example 2
arr2 = [1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3]
k2 = 4
print(solution.maxSumAfterPartitioning(arr2, k2))  # Output: 83

# Example 3
arr3 = [1]
k3 = 1
print(solution.maxSumAfterPartitioning(arr3, k3))  # Output: 1