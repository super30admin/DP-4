# TimeComplexity:O(N)
# SpaceComplexity:O(N)
# BruteForce:tarting at index i, I’ll try all partitions of size 1 to k (as long as they don’t exceed the array bounds).
# For each partition, I’ll calculate the contribution to the total sum, and recursively solve the rest of the array starting from the next index.
# Optimal: lot of repeated sub problems (Always draw tree to see this ) at dp[i] you go back ktime and check whats best value at dp[i




class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        dp=[0 for i in range(len(arr))]
        dp[0]=arr[0]
        m=arr[0]
        for i in range(1,len(arr)):
            
            if i>=k:
                m=arr[i]
                
                for j in range(i,i-k,-1):
                    m=max(m,arr[j])
                    dp[i]=max(dp[i],dp[j-1]+ (i-j+1)*m)

            else:
                m=max(m,arr[i])
                dp[i]=m*(i+1)
        return dp[-1]



class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:    #This gives us an exponential solution with a time complexity of roughly O(k^n), 
  #because at every index, we make up to k recursive calls. So it won't work efficiently for large arrays."


        n = len(arr)

        def dfs(i):
            if i == n:
                return 0
            
            max_val = 0
            max_sum = 0

            # Try all partition sizes from 1 to k
            for j in range(i, min(i + k, n)):
                max_val = max(max_val, arr[j])
                length = j - i + 1
                total = max_val * length + dfs(j + 1)
                max_sum = max(max_sum, total)
            
            return max_sum

        return dfs(0)
        
