/*
# brute force
// Time - O(m^2 * n^2) space - O(1)
class Solution:
def maximalSquare(self, matrix: List[List[str]]) -> int:
    if matrix is None or len(matrix) == 0:
        return 0
    
    rows = len(matrix)
    cols = len(matrix[0])
    cnt = 0
    for i in range(rows):
        for j in range(cols):
            if matrix[i][j] == '1':
                square = True
                cur = 1
                while i+cur < rows and j+cur < cols and square:
                    # check rows
                    for k in range(i+cur, i-1, -1):
                        if matrix[k][j+cur] == "0":
                            square = False
                            break

                    # check column
                    for k in range(j+cur, j-1, -1):
                        if matrix[i+cur][k] == "0":
                            square = False
                            break
                    
                    if square:
                        cur += 1
                cnt = max(cnt, cur)
    return cnt*cnt

    
# modifying the given array
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if matrix is None or len(matrix) == 0:
            return 0
        
        rows = len(matrix)
        cols = len(matrix[0])
        cnt = 0
        for i in range(rows):
            for j in range(cols):
                if matrix[i][j] == '1':
                    if i-1 >= 0 and j-1 >= 0:
                        matrix[i][j] = min(int(matrix[i-1][j]), min(int(matrix[i][j-1]), int(matrix[i-1][j-1]))) + 1
                    
                cnt = max(cnt, int(matrix[i][j]))
                          
                          
                    
        return cnt*cnt


# dp with additional space
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if matrix is None or len(matrix) == 0:
            return 0
        
        rows = len(matrix)
        cols = len(matrix[0])
        dp = [[0 for _ in range(cols+1)] for i in range(rows+1)]     # be careful here not to use [[0*(cols+1)]]*(rows+1) as this will just create references to single list
        
        cnt = 0
        
        
        for i in range(1, len(dp)):
            for j in range(1, len(dp[0])):
                if matrix[i-1][j-1] == "1":
                    dp[i][j] = min(dp[i-1][j], min(dp[i][j-1], dp[i-1][j-1])) + 1
                cnt = max(cnt, dp[i][j])
                          
        
        return cnt*cnt
*/
        

/*
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;
        int cnt = 0;
        int rows = matrix.length, cols= matrix[0].length;
        
        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                if (matrix[i][j] == '1'){
                    boolean sq = true;
                    int cur = 1;
                    while (i+cur < rows && j+cur < cols && sq){
                        // column
                        for (int k=i+cur; k>=i; k--){
                            if (matrix[k][j+cur] == '0'){
                                sq = false;
                                break;
                            }
                            
                        }
                        // rows
                        for (int k=j+cur; k>=j; k--){
                            if (matrix[i+cur][k] == '0'){
                                sq = false;
                                break;
                            }
                            
                        }
                        if (sq)
                            cur ++;
                    }
                    cnt = Math.max(cnt, cur);
                }
            }
        }
        return cnt*cnt;
    }
}
*/

// Time - O(m*n)
// Space - O(m*n)
// Logic - Calculated for a smallest square and then used that calculation for the bigger squares

class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;
        int cnt = 0;
        int rows = matrix.length, cols= matrix[0].length;
        int[][] dp = new int[rows+1][cols+1];
        
        for (int i=1; i<dp.length; i++){
            for (int j=1; j<dp[0].length; j++){
                if (matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                    cnt = Math.max(cnt, dp[i][j]);
                
                }
            }
        }
        return cnt*cnt;
    }
}