#Time Complexity: O(n×k), where n is the length of arr, and k is the partition size. For each index, we iterate up to k to calculate the partition sums.
#Space Complexity: O(n) for the dp array.
class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        n = len(arr)
        #Assign dp matrix with all 0's initially
        dp = [0 * n for i in range(0,n)]
        #First element will have it's own value as only 1 partition is possible
        dp[0] = arr[0]
        #Start Iterating from second element in the array
        for i in range(1,n):
            #Initially max of the current partition (1 parition) will be element itself
            currMax = arr[i]
            #To go through k partitions
            for j in range(1,k+1):
                #Edge case to check if we can't check k partitions with the current element
                if(i-j+1>=0):
                    #Update currMax with existing element and the other elements in partition
                    currMax = max(currMax, arr[i-j+1])
                    #Edge case to check if there is a previous element after partition
                    if(i-j>=0):
                        #If there is a previous element then after multplying currMax with no.of elements in the partition and add the previous number
                        dp[i] = max(dp[i], currMax*j+dp[i-j])
                        #If not, then just multply the currMax of that partition with the no,. of elements in it.
                    else:
                        dp[i] = max(dp[i], currMax * j)
        #return the last element of the dp matrix of get the maximum sum
        return dp[n-1]
       
        

