class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        """Dynamic Programming
        Time complexity-O(m*n)
        Space complexity-O(n) as using array"""
        if not matrix:
            return 0
        maxele=0
        prev=0
        dparr=[0 for i in range(len(matrix[0])+1)]
        for i in range(1,len(matrix)+1):
            for j in range(1,len(matrix[0])+1):
                if matrix[i-1][j-1]=='1':
                    temp=dparr[j]
                    dparr[j]=min(int(dparr[j-1]), min(int(dparr[j]), prev))+1
                    prev=temp
                    maxele=max(maxele, dparr[j]*dparr[j])
                else:
                    dparr[j]=0
        return maxele
        """Dynamic Programming
        Time complexity-O(m*n)
        Space complexity-O(m*n)"""
        # if not matrix:
        #     return 0
        # maxele=0
        # dpmatrix=[[0 for i in range(len(matrix[0])+1)] for j in range(len(matrix)+1)]
        # # dpmatrix[0]=matrix[0]
        # # if '1' in matrix[0]:
        # #     maxele=1
        # # for i in range(len(matrix)):
        # #     print(matrix[i][0])
        # #     dpmatrix[i][0]=matrix[i][0]
        # #     if matrix[i][0]=='1':
        # #         maxele=1
        # for i in range(1, len(dpmatrix)):
        #     for j in range(1, len(dpmatrix[0])):
        #         if matrix[i-1][j-1]=='1':
        #             dpmatrix[i][j]=min(int(dpmatrix[i-1][j]), min(int(dpmatrix[i][j-1]), int(dpmatrix[i-1][j-1])))+1
        #             maxele=max(maxele, dpmatrix[i][j]*dpmatrix[i][j])
        # return maxele
        
        """Brute force approach
            Time complexity-O((mn)^2) as in worst case each element would pick all matrix values to check if they form maximal square
            Space complexity-O(1)"""
        # if not matrix:
        #     return 0
        # maxsquare=0
        # for i in range(len(matrix)):
        #     for j in range(len(matrix[0])):
        #         count=0
        #         flag=True
        #         if matrix[i][j]=='1':
        #             count+=1
        #             curr=1
        #             while i+curr<len(matrix) and j+curr<len(matrix[0]) and matrix[i+curr][j+curr]=='1' and flag:
        #                 for row in range(i,i+curr):
        #                     if matrix[row][j+curr]!='1':
        #                         flag=False
        #                         break
        #                 for col in range(j, j+curr):
        #                     if matrix[i+curr][col]!='1':
        #                         flag=False
        #                         break
        #                 curr+=1
        #                 if flag:
        #                     count+=1
        #             maxsquare=max(maxsquare, count*count)
        # return maxsquare
        
                    