#  Time Complexity : O(n * k)
#  Space Complexity : O(n) where n is the number of elements in the array 
#  Did this code successfully run on Leetcode : Yes
#  Three line explanation of solution in plain english : This code solves the “Maximum Sum After Partitioning” problem using top-down dynamic programming with memoization. At each index, it tries all possible partitions of size up to k, finds the maximum element in that partition, and computes the best total sum recursively for the remaining array. The memo array stores intermediate results to avoid recomputation, ensuring an overall O(n × k) time complexity.
class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        memo = [-1] * len(arr)
        return self.helper(arr, 0, k, memo)
    
    def helper(self, arr: List[int], index: int, k: int, memo: List[int]) -> int:
        # Base case
        if index == len(arr):
            return 0
        
        if memo[index] != -1:
            return memo[index]
        
        ans = 0
        max_in_part = 0
        
        for part in range(1, k + 1):
            end = index + part - 1
            if end >= len(arr):
                break
            
            max_in_part = max(max_in_part, arr[end])
            current_sum = max_in_part * part + self.helper(arr, end + 1, k, memo)
            ans = max(ans, current_sum)
        
        memo[index] = ans
        return ans