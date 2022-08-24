#1043. Partition Array for Maximum Sum
"""
Time Complexity : O(k ^ n) # k choices for n elements n = len(arr)
Space COmplexity : O(n) #dp array of len(arr)
"""
class Solution:
    def maxSums(self, partition):
        m = max(partition)
        return m * len(partition)
        
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        n = len(arr)
        dp = [0] * (n)
        
        dp[0] = arr[0]
        #print(dp)
        
        for i in range(1, n):
            #print("original", arr[0:i+1:])
            m = 0
            for j in range(1, k+1):
                
                x = i - j
                
                if x >= -1:
                    partition = arr[x+1 : i+1 : 1]
                    #print(partition)
                    sum1 = self.maxSums(partition) #sum1 = maxSums from partition array
                    
                    leftOver = 0
                    if x >= 0:
                        leftOver = x
                        #print(partition, dp[leftOver])
                        sum2 = sum1 + dp[leftOver]
                    else:
                        #print(partition, leftOver)
                        sum2 = sum1 + leftOver
                    m = max(m, sum2)
                    dp[i] = m
            
            #print(dp)
        
        return dp[-1]
