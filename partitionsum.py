# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
class Solution(object):
    def maxSumAfterPartitioning(self, A, K):
        """
        :type A: List[int]
        :type K: int
        :rtype: int
        """
        n = len(A)
        maxpartition = [0]*(n+1)
        maxpartition[0] = 0
        
        for i in range(1,len(maxpartition)):
            maxpartitionvalue = float('-inf')
            k = i-1
            j = 1
            
            maxvalue = float('-inf')
            while j<=K:
                if k < 0:
                    break
                maxvalue = max(maxvalue, A[k])
                maxpartition[i] = max(maxpartitionvalue, max(maxvalue, maxpartition[i-j]+maxvalue*j))
                maxpartitionvalue = maxpartition[i]
                k -=1
                j +=1
        
        return maxpartition[-1]
                
                
            
            
        
            
                
            
        