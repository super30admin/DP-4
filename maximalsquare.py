#Time Complexity: O(mn)
#Space Complexity: O(1)
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        m = len(matrix)
        n = len(matrix[0])
        maxm = 0
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == '1':    
                    if i-1 >=0 and j-1>=0:
                        matrix[i][j] = min(int(matrix[i-1][j-1]),int(matrix[i][j-1]),int(matrix[i-1][j]))+1
                    maxm = max(maxm,int(matrix[i][j]))
    
        return maxm*maxm