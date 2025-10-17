"""
TC: O(N*M) We iterate through the entire matrix twice, once to find an initial '1' and once for the DP calculation. The total time is linear with respect to the matrix size.
SC: O(1) The space complexity is constant because we modify the input matrix in place to store the DP results.

Approach:

This problem is solved using Dynamic Programming (DP) with an in-place modification of the input matrix. The goal is to find the largest square composed entirely of '1's and return its area.

The core idea is to transform each cell (i, j) containing a '1' into a value representing the side length of the largest square that has (i, j) as its top-left corner. We iterate through the matrix from bottom-right to top-left.

For a cell matrix[i][j] that is '1', the side length of the square it can form is determined by the minimum side length of the squares formed by its three neighbors: the cell to the right, the cell below, and the cell on the diagonal (bottom-right). The formula is: DP[i][j] = 1 + min(DP[i][j+1], DP[i+1][j], DP[i+1][j+1]).

We track the maximum side length found during the DP process in the res variable. After the traversal, the final answer is the area, which is res times res.

The problem ran successfully on LeetCode.
"""
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        n,m = len(matrix), len(matrix[0])

        res = 0

        for i in range(n):
            for j in range(m):
                if matrix[i][j] == '1':
                    res = 1

        for i in range(n-2, -1, -1):
            for j in range(m-2, -1, -1):
                curr = matrix[i][j]

                if curr == "1":

                    right = matrix[i][j+1]
                    down = matrix[i+1][j]
                    diag = matrix[i+1][j+1]

                    matrix[i][j] = int(curr) + min(int(right), int(down), int(diag))

                    res = max(res, matrix[i][j])

        
        return res*res