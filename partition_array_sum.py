# Time Complexity : O(n**2)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english
# We start at index 1 and go atmost k steps back into the array to find the max number in range of K we then compare max*j, where j is between 1 and k
# We compare current result with previous iteration and maintain max in a memoization array. We return the last element in this memoization array.

class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        length = len(arr)
        memo = [0 for x in range(length)]
        memo[0] = arr[0]
        for i in range(1, length):
            j = 1
            maxi = arr[i] # 15
            memo[i] = arr[i]+memo[i-1]
            while i-j >= 0 and j < k: # 0>=0 1<3
                maxi = max(maxi, arr[i-j]) # 15
                candidate_sum = maxi*(j+1)
                previous_sum = memo[i-j-1] if i-j > 0 else 0
                memo[i] = max(memo[i], candidate_sum+previous_sum) # 1
                j+=1
   
        return memo[-1]
