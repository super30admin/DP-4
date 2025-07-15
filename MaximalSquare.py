# Time Complexity: O(m * n * min(m, n)) 
# Space Complexity: O(1)
# This solution iterates through each cell in the matrix and checks for the maximal square that can be formed with '1's starting from that cell.
# At each cell, it expands the square as long as it can maintain the condition of all '1's in the new row and column added to the square.

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if not matrix or not matrix[0]:
            return 0
        
        m, n = len(matrix), len(matrix[0])
        max_len = 0

        for i in range(m):
            for j in range(n):
                if matrix[i][j] == '1':
                    # Start with a square of size 1
                    length = 1
                    # Check if we can expand the square
                    flag = True

                    while i + length < m and j + length < n and flag:
                        # Check the new row
                        # In same row check if everything is 1:
                        for r in range(i, i + length + 1):
                            if matrix[r][j + length] == '0':
                                flag = False
                                break
                        # Check the new column
                        # In same column check if everything is 1:
                        for c in range(j, j + length + 1):
                            if matrix[i + length][c] == '0':
                                flag = False
                                break
                        if flag:
                            length += 1

                    max_len = max(max_len, length)

        return max_len * max_len

# Time Complexity: O(m * n) 
# Space Complexity: O(m * n)
# This solution uses dynamic programming to find the maximal square of '1's in the matrix.
# # It maintains a DP table where dp[i][j] represents the size of the largest square whose bottom-right corner is at (i, j).

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if not matrix or not matrix[0]:
            return 0

        m, n = len(matrix), len(matrix[0])
        # 
        dp = [[0] * (n + 1) for _ in range(m + 1)]
        max_len = 0

        for i in range(m):
            for j in range(n):
                if matrix[i][j] == '1':
                    # Update the DP table based on the previous values
                    # Minimum of the three neighbors (left, top, top-left) + 1
                    dp[i+1][j+1] = min(dp[i][j+1], dp[i+1][j], dp[i][j]) + 1
                    max_len = max(max_len, dp[i+1][j+1])

        return max_len * max_len

# Time Complexity: O(m * n) 
# Space Complexity: O(n)
# # This solution optimizes the space complexity by using a single array to store the current and previous row values.
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if not matrix or not matrix[0]:
            return 0

        m, n = len(matrix), len(matrix[0])
        dp = [0] * (n + 1)
        max_len = 0
        prev = 0  # Stores dp[j+1] from previous row (diagonal)

        for i in range(m):
            for j in range(n):
                temp = dp[j+1]
                if matrix[i][j] == '1':
                    dp[j+1] = min(dp[j], dp[j+1], prev) + 1
                    max_len = max(max_len, dp[j+1])
                else:
                    dp[j+1] = 0
                prev = temp

        return max_len * max_len
