# Time Complexity :
# O(NK)

# Space Complexity :
# O(N)

# Did this code successfully run on Leetcode :
#Yes

#We need the best way to parition the given element - and the parition size can be 0 to k.
#So, we check every possible partition from first element,  and find the best set of paritions for rest of the array - basically the same problem with a smaller array
#Now during the course of this, we will solve multiple repeated sub-problems - of best partition from a given location, hence we store this information in a DP array and if the best parition has already 
#been computed for the given sub-array, we return it

class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        n = len(arr)
        if n == 0 :
            return 0
        self.dp = [-1] * (len(arr))
        self.dp[0] = self.helper(arr,0,k)
        return self.dp[0]

    def helper(self,arr,pivot,k):
        if pivot == len(arr):
            return 0
        if len(arr[pivot:]) == 1 :
            return arr[pivot]

        if self.dp[pivot] != -1:
            return self.dp[pivot]

        for j in range(0,k):
            max_val = max(arr[pivot:pivot+j+1])
            curr_partition_sum = (j+1) * max_val
            self.dp[pivot] = max(curr_partition_sum + self.helper(arr,pivot+j+1,k),self.dp[pivot])
            if j+1 >= len(arr)-pivot :
                break

        return self.dp[pivot]

