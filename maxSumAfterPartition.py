class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        '''
        Time, Space Complexity: O(n)
        This question was difficult to understand and code
        '''
        dp = [0 for i in range(0,len(arr))]
        
        for i in range(0,len(arr)):
            j = 0
            max1=0
            while(i-j>=0 and j<k):
                max1 = max(arr[i-j],max1)
                if(i-j>0):
                    # edge case
                    dp[i] = max(dp[i], dp[i-j-1] + (j+1)*max1)
                else:
                    dp[i] = max(dp[i], (j+1)*max1)
                    
                j+=1
        
        return dp[-1]
