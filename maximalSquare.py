#Time Complexity: O(m*n)
#Space Complexity: O(n)
#Did it run on leetcode: Yes
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        
        dp={}
        ans=0
        m=len(matrix)
        n=len(matrix[0])
        for i in range(m):
            for j in range(n):
				#if 1 is encounteres than we have square of atleast size 1 length.
                if matrix[i][j]=="1":
                    maxarea=1
					#if there is possible bigger square then (i-1)(j-1) should be square too
                    if (i-1,j-1) in dp:
						#find the size of squre before this, max size of square can be found would be size +1
                        size=dp[(i-1,j-1)]
                        
                        foundsizex=0
                        for k in range(1,size+1):
                            if matrix[i-k][j]!='1':
                                break
                            foundsizex+=1
                                
                        foundsizey=0   
                        for k in range(1,size+1):
                            if matrix[i][j-k]!='1':
                                break
                            foundsizey+=1
                        maxarea=1+min(foundsizex,foundsizey)    
                    ans=max(ans,maxarea)
                    dp[(i,j)]=maxarea
        return ans*ans