#TC : O(nk)
#SC : O(n)

#Accepted on Leetcode

#Approach: 
#Use a DP Array to compute max partition sum for each index -> check with it's previous 3 arr[i] values 
#For each partition, prevSum (maximum sum of best previous partition) will be stored in the index behind the partition index in dp array

 

class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        n = len(arr)
        dp = [x for x in arr]
        for i in range(1, n):
            #0 to k - 1
            maxElem = arr[i]
            maxVal = arr[i]
            for windowSize in range(k):
                if i - windowSize < 0:
                    break
                curBoundaryElem = arr[i - windowSize]
                maxElem = max(maxElem, curBoundaryElem)
                prevSum =  dp[i - windowSize - 1] if i - windowSize - 1 >= 0 else 0
                partitionSum = maxElem * (windowSize + 1)
                maxVal = max(prevSum + partitionSum, maxVal)

            # print(arr)

            dp[i] = maxVal
        
        return dp[-1]
        
                
