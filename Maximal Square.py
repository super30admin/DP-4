Optimised Brute Force:

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        
        
        rows = len(matrix)
        cols = len(matrix[0])
           
        output = 0
        for i in range(rows):
            for j in range(cols):
                if matrix[i][j] == "1":
                    curr = 1
                    flag = True
                    # newI, newJ = i+curr, j+curr
                    while(i+curr<rows and j+curr<cols and flag):
                        newI, newJ = i+curr, j+curr
                        for a in range(newJ, j-1, -1):
                            if matrix[newI][a]=="0":
                                flag = False
                                break
                        #rowwise
                        for b in range(newI, i-1, -1):
                            if matrix[b][newJ]=="0":
                                flag = False 
                                break
                        if flag:
                            curr+=1
                        else:
                            break
                    output = max(curr, output)
        return output**2
 Time: mn^2
 Space:  O(1)
        
DP:
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        
        
        rows = len(matrix)
        cols = len(matrix[0])
        dp = [[1 if ch == '1' else 0 for ch in row] for row in matrix]
        output = 0
        for i in range(1, rows):
            for j in range(1, cols):
                if matrix[i][j] == "1":
                    dp[i][j] = min(int(dp[i-1][j]), int(dp[i][j-1]), int(dp[i-1][j-1]))+1
                    output = max(output,  int(dp[i][j]))
                
        return max(max(row) for row in dp) ** 2
        
        
Time: O(mn)        
Space: O(mn)
    
      
                        
