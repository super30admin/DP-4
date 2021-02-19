class Solution:
    
    """
    Description: Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's
    
    Time complexity: O(m*n)
    Space complexity: O(m*n)
    
    Approach: Use a dp matrix with same size
    - initiate first row and column same values as in the given matrix:
    - keep a variable max_size and update dp matrix when value is "1"
    - use min of cross diagonal, up and left value + 1 to update the matrix
    - last value in matrix give size of square starting from found "1"
    - update max_size if the last value is greather than before
    """
    
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        
        if matrix == None: return 0
        
        max_size = 0;
        n_rows, n_cols = len(matrix), len(matrix[0])
        
        dp = [[0]*n_cols for __ in range(n_rows)]
        dp[0] = [int(matrix[0][i]) for i in range(n_cols)] # first row
        for j in range(n_rows):
            dp[j][0] = int(matrix[j][0]) 

        for i in range(0, n_rows):
            for j in range(0, n_cols):
                if i > 0 and j > 0:
                    if matrix[i][j] == "1":
                        dp[i][j] = min(dp[i - 1][j - 1],
                                       dp[i - 1][j], dp[i][j - 1]) + 1
                        max_size = max(max_size, dp[i][j])
                else: max_size = max(max_size, dp[i][j])
                    
        return max_size*max_size
