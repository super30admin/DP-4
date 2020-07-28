class Solution: 
    
    """
        
        Name : Shahreen Shahjahan Psyche
        Time : O(M*N) [M and N is represents the Row and Column of the Matrix]
        Space: O(M*N)
        
        Passed All Test Case in LC : Yes
    
    """
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        
        if not matrix:
            return 0
        
        m = len(matrix)
        n = len(matrix[0])
        track = [[0 for _ in range((n+1))] for _ in range(m+1)]
        max_area = 0
        
        for i in range(1, m+1):
            for j in range(1, n+1):
                if matrix[i-1][j-1] == "1":
                    # taking the minimum value of three elements
                    track[i][j] = 1 + min(track[i-1][j-1], track[i-1][j], track[i][j-1])
                    
        for i in range(1, m+1):
            for j in range(1, n+1):
                if track[i][j] > max_area:
                    max_area = track[i][j]
                    
                        
        return max_area*max_area
                
                
        
        
