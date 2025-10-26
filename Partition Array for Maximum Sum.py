'''
Solution 1: Recursion 
    - For loop based recursion. At each pivot, we try partitioning from 1->k
    - Track the max_sum that we get by exploring all partitions at each pivot. 
    - For current partitioned array at this pivot, track max_element by comparing 
      it with incoming element
Time Complexity: O(k^L) k = max length of sub-array, L = lenth of array
Space Complexity: O(L) Recursive stack
'''
class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:

        return self.helper(arr, k, 0)

    def helper(self,arr,k,pivot):
        # base - <not needed>
        
        # logic
        max_sum = 0 # max_sum at this pivot, exploring all paritions options 
        current_partition_max = 0
        for index in range(pivot, min(pivot+k,len(arr))):
            current_partition_max = max(current_partition_max,arr[index]) # max element in partitioned array
            current_partition_total =  current_partition_max*(index-pivot+1) # total sum in partitioned array
            max_sum_after_partitioning = current_partition_total + self.helper(arr,k,index+1) 
            max_sum = max(max_sum, max_sum_after_partitioning) # at this pivot, max_sum after exploring paritions
        
        return max_sum

'''
Solution 1: Recursion + Memoization 
    - For loop based recursion. At each pivot, we try partitioning from 1->k
    - Track the max_sum that we get by exploring all partitions at each pivot. 
    - For current partitioned array at this pivot, track max_element by comparing 
      it with incoming element
    - Store the max_sum after partitioning at this pivot in memory bank
Time Complexity: O(k*L) k = max length of sub-array, L = lenth of array
Space Complexity: O(L) memory bank
'''

class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        self.memory = {} # {pivot - sum}
        return self.helper(arr, k, 0)

    def helper(self,arr,k,pivot):
        # base
        if pivot in self.memory:
            return self.memory[pivot]

        # logic
        max_sum = 0 # max_sum at this pivot, exploring all paritions options 
        current_partition_max = 0
        for index in range(pivot, min(pivot+k,len(arr))):
            current_partition_max = max(current_partition_max,arr[index]) # max element in partitioned array
            current_partition_total =  current_partition_max*(index-pivot+1) # total sum in partitioned array
            max_sum_after_partitioning = current_partition_total + self.helper(arr,k,index+1) 
            max_sum = max(max_sum, max_sum_after_partitioning) # at this pivot, max_sum after exploring paritions
        
        self.memory[pivot] = max_sum # memoization

        return max_sum


'''
Solution 3: DP - Tabulation 
    - At each pivot, we try partitioning from pivot -> pivot-k
    - Track the max_sum that we get by exploring all partitions at each pivot. 
    - For current partitioned array at this pivot, track max_element by comparing 
      it with incoming element
    - Store the max_sum after partitioning at this pivot at dp[pivot]
Time Complexity: O(k*L) k = max length of sub-array, L = lenth of array
Space Complexity: O(L) dp_array
'''

class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        dp_array = [0]*len(arr)

        for pivot in range(len(arr)):
            j = pivot
            max_sum = 0 # max sum at this pivot after exploring all partitions
            current_partition_max = 0 
            while j>=0 and j>pivot-k:
                current_partition_max = max(current_partition_max,arr[j]) # max element in current partition
                current_partition_total = current_partition_max*(pivot-j+1) # total sum of current partition
                if j>0:
                    max_sum_after_partitioning = current_partition_total + dp_array[j-1] # current partition total + max sum of partitioning elements before this current partition
                    max_sum = max(max_sum_after_partitioning, max_sum)
                else:
                    max_sum = max(current_partition_total, max_sum)
                j-=1
            dp_array[pivot] = max_sum # best Max sum after exploring all partitions at this pivot
        
        return dp_array[-1]