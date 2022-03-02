# Time Complexity : O(nm)
# Space Complexity : O(nm)
# Did this code successfully run on leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        m, n = len(matrix), len(matrix[0])
        matrix = [[int(matrix[i][j]) for j in range(n)] for i in range(m)]
        t = []
        for val in matrix:
            t.append(val)
            
        for i in range(m-2, -1, -1):
            for j in range(n-2, -1, -1):
                if t[i][j] == 1:
                    t[i][j] = min(t[i+1][j], t[i][j+1], t[i+1][j+1]) + 1
        
        max_val = 0
        for val in t:
            max_val = max(max_val, max(val))
        
        return max_val**2