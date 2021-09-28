# Tc:O(N)
# SC:O(N)
class Solution:
    def maxSumAfterPartitioning(self, A: List[int], K: int) -> int:
        
        # initialization
        dp_sum = [0 for x in range(len(A))]
        dp_sum[0] = A[0]
        max_so_far = A[0]
        for x in range(1,K):
            max_so_far = max(max_so_far, A[x])
            dp_sum[x] = (x+1)*max_so_far

        
        # find the maximum sum so far as if this is the end of a partition
        for ind in range(K, len(dp_sum)):
            
            # go back K-1 steps to find the maximum so far
            
            partition_max = 0
            for back in range(K):
                partition_max = max(partition_max, A[ind - back])
                prev_sum = dp_sum[ind - back - 1]
                
                dp_sum[ind] = max(dp_sum[ind], prev_sum + (back+1)*partition_max)
        
        
        return dp_sum[-1]