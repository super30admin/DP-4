'''
TC: O(m*n) ~ O(N) where m and n are the ROWS and COLS respectively
SC: O(1) - Computing in place with just few pointers for DP
'''
from typing import List

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        ROWS, COLS = len(matrix), len(matrix[0])
        maxRes = -float('inf')
        for i in range(ROWS-1,-1,-1):
            for j in range(COLS-1,-1,-1):
                maxRes = max(maxRes, int(matrix[i][j]))
                if matrix[i][j] == '1' and i+1<ROWS and j+1<COLS:
                    v = min(int(matrix[i+1][j+1]),int(matrix[i][j+1]),int(matrix[i+1][j]))+1
                    maxRes = max(maxRes, v)
                    matrix[i][j] = str(v)
        return maxRes*maxRes
s = Solution()
print(s.maximalSquare([["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]))
print(s.maximalSquare([["0","1"],["1","0"]]))
print(s.maximalSquare([["0"]]))