#All TC passed on leetcode


class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:

        #Here we create combinations of each element's 1-k partition and take max of those partitions and store in dp. 
        #Time complexity - O(n*k)
        #Space complexity - O(n) - this can be further reduced to just k, we keep track of last elements only.
        n = len(arr)
        dp = [0]*n

        for i in range(n):
            curMaxNum = arr[i]
            for j in range(1,k+1):
                if (i-j+1)>=0:
                    curMaxNum = max(curMaxNum, arr[i-j+1])
                    curPartitionVal = curMaxNum*j 
                    if (i-j)>=0:
                        curPartitionVal = curMaxNum*j + dp[i-j]
                    dp[i] = max(dp[i], curPartitionVal)
        return dp[n-1]