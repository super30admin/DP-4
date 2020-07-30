# Time Complexity : O(mxn) 
# Space Complexity :O(mxn) ,for dp matrix.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

# Time = O(m^2 x n^2) | Space = O(1)
# class Solution:
#     def maximalSquare(self, matrix: List[List[str]]) -> int:
#         if len(matrix) == 0:
#             return 0 
#         n = len(matrix)
#         m = len(matrix[0])
#         flag = False
#         max_ = 0 
        
#         for i in range(n):
#             for j in range(m):
#                 if matrix[i][j] == '1':
#                     flag = True 
#                     curr = 1 
#                     while i + curr < n and j + curr < m and flag:
#                         k = i + curr
#                         while k >= i:
#                             if matrix[k][j + curr] == '0':
#                                 flag = False 
#                                 break 
#                             k -= 1 
                        
#                         k = j + curr 
#                         while k >= j:
#                             if matrix[i+curr][k] =='0':
#                                 flag = False 
#                                 break 
#                             k -= 1 
                        
#                         if flag:
#                             curr += 1 
                            
#                     max_ = max(max_ , curr)
#         return max_ * max_
    
    
class Solution:
    def maximalSquare(self, matrix) :
        if len(matrix) == 0:
            return 0 
        result = 0 
        dp = [[0 for _ in range(len(matrix[0]) + 1)] for _ in range(len(matrix) + 1)]
        m , n = len(dp) , len(dp[0])
        
        for i in range(1,m):
            for j in range(1,n):
                if matrix[i-1][j-1] == '1':
                    dp[i][j] = min(dp[i-1][j], dp[i][j-1],dp[i-1][j-1]) + 1 
                    result = max(result, dp[i][j])
        
        return result*result
    
if __name__ == "__main__":
    s = Solution()
    # Test case 1: 
    print(s.maximalSquare([["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]))