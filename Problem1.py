# DP-4
## Problem1:(https://leetcode.com/problems/maximal-square/)

# Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

# Example:

# Input: 


# 1 0 1 0 0

# 1 0 1 1 1

# 1 1 1 1 1

# 1 0 0 1 0

# Output: 4









class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        """
        Iterative Solution
        """
        # maxSize = 0
        # rows, cols = len(matrix), len(matrix[0])

        # for r in range(rows):
        #     for c in range(cols):
        #         if matrix[r][c] == "1":
        #             size = 1
        #             is1 = True
        #             while r + size < rows and c + size < cols and is1:
        #                 for k in range(r + size, r - 1, -1):
        #                     if matrix[k][c + size] == "0":
        #                         is1 = False
        #                         break
                        
        #                 if not is1:
        #                     break
                        
        #                 for k in range(c + size, c - 1, -1):
        #                     if matrix[r + size][k] == "0":
        #                         is1 = False
        #                         break
        #                 if is1:
        #                     size += 1
        #             maxSize = max(maxSize, size)
        
        # return maxSize * maxSize


        

        """
        DP Solution
        LOGIC EXPLANATION:
        ------------------
        We use Dynamic Programming with a 1D array to find the area of the largest square of 1s.
        
        Let dp[c] represent the maximum side length of a square whose top-left corner starts 
        at position (r, c).
        
        To compute dp[c] for matrix[r][c], we look at three neighboring values:
        1. dp[c]      -> Square side achievable directly below (r+1, c)
        2. dp[c + 1]  -> Square side achievable directly to the right (r, c+1)
        3. diagonal   -> Square side achievable diagonally down-right (r+1, c+1)
        
        Transition Relation:
        If matrix[r][c] == "1":
            dp[c] = min(diagonal, dp[c], dp[c + 1]) + 1
        Else:
            dp[c] = 0
            
        We iterate backwards from the bottom-right corner to the top-left corner (r, c).
        'diagonalDown' preserves the previous state of dp[c] (i.e., bottom-right value) 
        before it gets overwritten by the current row calculation.
        """
        
        # Edge Case: Return 0 if the matrix is empty
        if not matrix or not matrix[0]:
            return 0
        
        rows, cols = len(matrix), len(matrix[0])
        
        # 1D DP table padded with 1 extra element to handle boundaries gracefully without index-out-of-bounds checks
        dp = [0] * (cols + 1)
        max_size = 0
        
        # Iterate backwards through rows (bottom to top)
        for r in range(rows - 1, -1, -1):
            diagonalDown = 0  # Stores dp[r+1][c+1] for the current cell
            
            # Iterate backwards through columns (right to left)
            for c in range(cols - 1, -1, -1):
                temp = dp[c]  # Save old dp[c] (which acts as diagonalDown for the next cell to the left)
                
                if matrix[r][c] == "1":
                    # Take the minimum of (Down-Right Diagonal, Down, Right) + 1
                    dp[c] = min(diagonalDown, dp[c], dp[c + 1]) + 1
                    max_size = max(max_size, dp[c])
                else:
                    dp[c] = 0
                
                # Update diagonalDown for the cell to the left (c - 1)
                diagonalDown = temp
        
        # Return the area (side * side)
        return max_size * max_size


        """
        COMPLEXITY ANALYSIS:
        --------------------
        Time Complexity: O(M * N)
        - M is the number of rows and N is the number of columns in the matrix.
        - We visit every cell (r, c) exactly once in a nested loop and perform O(1) operations per cell.

        Space Complexity: O(N)
        - N is the number of columns in the matrix.
        - Instead of maintaining an M x N 2D grid (O(M * N) space), we optimize space by maintaining 
        only a 1D DP array of size (N + 1) to store row values.
        """