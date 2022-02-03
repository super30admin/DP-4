class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        """
        Time complexity : O(nm)
        Space complexity : O(nm)
        Maximal Square
        """
        self.max = 0
        self.dp = []
        for i in range(0,len(matrix)):
            temp = []
            for j in range(len(matrix[0])):
                if j == 0 or i == 0:
                    temp.append(int(matrix[i][j]))
                    self.max = max(self.max,int(matrix[i][j]))
                else:
                    temp.append(0)
            self.dp.append(temp)
        print(self.dp)
                    
        for i in range(1,len(matrix)):
            for j in range(1,len(matrix[0])):
                if matrix[i][j] == '1':
                    self.dp[i][j] = min(int(self.dp[i-1][j]),int(self.dp[i-1][j-1]),int(self.dp[i][j-1])) + 1
                    print(self.dp[i][j])
                    self.max = max(self.max,self.dp[i][j])
                else:
                    self.dp[i][j] = 0
                
        return self.max**2
                
                
                
                
        
                    
            
        