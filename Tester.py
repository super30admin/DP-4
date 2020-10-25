# Time - O(n . K) 
# we look back k steps back 
#Space - (n)



class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        if not arr:
            return 0
        
        dp = [0 for i in range(len(arr))]
        dp[0] = arr[0]
        max_curr = arr[0]
        # mxi = float('-inf')      
        
              
        for j in range(1,k):
#             getting curr max
                max_curr = max(max_curr ,arr[j])
#     Here we are multiplying the max_curr with the size of the sub -array
                dp[j] = (j+1)* max_curr
    
#         Now we find the maximum so far until now ,as if it is the end of the partition...
        for i in range(k,len(arr)):
                partition_maximum = 0
            
            # go back K-1 steps to find the maximum so far
                for z in range(k):
                    partition_maximum = max(partition_maximum,arr[i - z])
                    prev_sum = dp[i - z - 1]

                    dp[i] = max(dp[i], prev_sum + (z+1)*partition_maximum)

        return dp[-1]
                
                
                
        
            
        
                    
                    
        
        
        
                    
                
                
            
            
            
            
                    
                    

                
                
        
        