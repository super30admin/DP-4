#Space Complexity = O(m)
#Time Complexity = O(n)

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if(matrix==None or len(matrix)==0):
            return 0
        m = len(matrix[0])
        n = len(matrix)
        dp = [[0 for i in range(m)]for i in range(n)]
        final  = 0
        for i in range(n):
            for j in range(m):
                if(i==0 or j==0):
                    matrix[i][j] = int(matrix[i][j])
                    
                else:
                    if(matrix[i][j]=="1"):
                        matrix[i][j] = min(matrix[i-1][j],matrix[i][j-1],matrix[i-1][j-1]) +1
                    else:
                        matrix[i][j] = 0
                final = max(matrix[i][j],final)
        return final*final
                    
                