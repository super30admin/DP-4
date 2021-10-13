# // Time Complexity :O((m*n)^2)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :
# // Any problem you faced while coding this :


# // Your code here along with comments explaining your approach




class Solution:
    
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        
        m=len(matrix)
        n=len(matrix[0])
        flag=False
        curr=0
        ma=0
        
        for i in range(m):
            for j in range(n):
                if matrix[i][j]=='1':
                    flag=True
                    curr=1
                    print("x")
                    print(i,j)
                    while(i+curr<m and j+curr<n and flag is True):

                        print("m",curr)
                        for k in range(j,j+curr+1):
                            if matrix[i+curr][k]=='0':
                                flag=False
                                break
                        for k in range(i,i+curr+1):
                            if matrix[k][j+curr]=='0':
                                flag=False
                                break
                        if flag:
                            curr=curr+1
                    ma=max(ma,curr)
                    print(ma)
        return ma*ma
                
        