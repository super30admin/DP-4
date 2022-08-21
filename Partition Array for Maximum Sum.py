# Time complexity: O(nk)
# Space complexity: O(n)
# Approach: For each index, maintain a maximum sum array which can be used for repeating subproblems.
# At each index, from that index to kth index before that, 
# compute sum partitioning using one k
# at a time and take the maximum sum and store it for that index.


class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        if arr == None or len(arr) == 0:
            return 0
        n = len(arr)
        dp = [0 for i in range(n)]
        for i in range(0,n):
            maxElement = arr[i]
            for j in range(1,k+1):
                if i-j+1 >= 0:
                    maxElement = max(maxElement, arr[i - j + 1])
                    if (i - j >= 0):
                        currentSum = (j * maxElement) + dp[i - j]
                    else:
                        currentSum = (j * maxElement) + 0
                    dp[i] = max(dp[i], currentSum)
        return dp[i]
                    
                
        