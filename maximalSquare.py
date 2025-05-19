class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        """
        Approach:
        1. Use a bottom-up 1D dynamic programming array `dp` of size (n+1) to simulate a 2D DP matrix.
        2. Traverse the matrix from bottom-right to top-left.
        3. For each cell with value '1', calculate the size of the largest square ending at that cell using:
           dp[j] = 1 + min(dp[j], dp[j + 1], diagonal)
           where:
               - dp[j] represents the value from the row below (i+1, j)
               - dp[j + 1] represents the value from the right (i, j+1)
               - diagonal represents the value from (i+1, j+1), stored in a temp variable
        4. Track the maximum square size found in `result`, and return result * result.

        Time Complexity: O(m * n) — Each cell is processed once.
        Space Complexity: O(n) — Only a single row of the DP matrix is maintained at any time.
        """
        m = len(matrix)
        n = len(matrix[0])

        result = 0
        dp = [0 for _ in range(n + 1)]
        diagonal = 0

        for i in range(m - 1, -1, -1):
            for j in range(n - 1, -1, -1):
                temp = dp[j]
                if matrix[i][j] == '1':
                    dp[j] = 1 + min(dp[j], diagonal, dp[j + 1])
                    result = max(result, dp[j])
                else:
                    dp[j] = 0
                diagonal = temp

        return result * result
