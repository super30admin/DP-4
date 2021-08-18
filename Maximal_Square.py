#Space :O(m*n)
#Time : O(m*n)
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        ans = 0
        m = len(matrix)
        n = len(matrix[0])
        dp_matrix =[[0 for _ in range(n+1)] for _ in range(m+1)]
        for i in range(1,m+1):
            for j in range(1,n+1):
                if matrix[i-1][j-1] == "0":
                    continue
                dp_matrix[i][j] = 1 + min(dp_matrix[i][j-1],dp_matrix[i-1][j],dp_matrix[i-1][j-1])
                ans = max(dp_matrix[i][j],ans)
        return ans*ans
                
                            
                            
                
        