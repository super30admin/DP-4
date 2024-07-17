# Time Complexity : O(mxn)
# Space Complexity : O(n)

class Solution:
    def maximalSquare(self, matrix):
        if not matrix or not matrix[0]:
            return 0
        
        m, n = len(matrix), len(matrix[0])
        max_side = 0
        dp = [0] * (n + 1)
        
        for i in range(1, m + 1):
            temp = dp[0]
            for j in range(1, n + 1):
                prev = dp[j]
                if matrix[i - 1][j - 1] == '1':
                    dp[j] = 1 + min(dp[j - 1], min(dp[j], temp))
                    max_side = max(max_side, dp[j])
                else:
                    dp[j] = 0
                temp = prev

        return max_side * max_side

# Examples to demonstrate the solution
solution = Solution()

# Example 1
matrix1 = [
    ['1', '0', '1', '0', '0'],
    ['1', '0', '1', '1', '1'],
    ['1', '1', '1', '1', '1'],
    ['1', '0', '0', '1', '0']
]
print(solution.maximalSquare(matrix1))  # Output: 4

# Example 2
matrix2 = [
    ['0', '1'],
    ['1', '0']
]
print(solution.maximalSquare(matrix2))  # Output: 1

# Example 3
matrix3 = [
    ['0']
]
print(solution.maximalSquare(matrix3))  # Output: 0