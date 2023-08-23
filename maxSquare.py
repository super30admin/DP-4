#TC - O(mn)
#SC - O(mn)
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        ROWS = len(matrix)
        COLS = len(matrix[0])
        dp = {}

        def f(r,c):
            if r>=ROWS or c>=COLS:
                return 0 
            if (r,c) not in dp:
                down = f(r+1,c)
                right = f(r,c+1)
                diag = f(r+1,c+1)
                dp[(r,c)] = 0
                if matrix[r][c]=="1":
                    dp[(r,c)] = 1 + min(down,diag,right)
            return dp[(r,c)]
        
        f(0,0)
        return max(dp.values())**2