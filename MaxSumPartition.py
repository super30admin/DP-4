'''
Solution:
1.  For each index, maintain a maximum sum array which can be used for repeating subproblems.
2.  At each index, from that index to kth index before that, compute sum partitioning using one k
    at a time and take the maximum sum and store it for that index.
3.  Recurrence relation:
    
    maximum {
    1<=j<=k     maxSums[i - j] + (j * max(arr[i-j+1 : i]))
            }

                    maxSums will be valid only if i - j is >= 0; else 0
                    arr[i-j+1 : i] will be valid only if i-j+1 >= 0 which is a stopping condition for inner loop.
                    max(arr[i-j+1 : i]) can be computed in parallel while iterating j from 1 to k

Time Complexity:    O(n * k)
Space Complexity:   O(n)

--- Passed all testcases on leetcode successfully
     
'''


class MaxSumPartition:
    def maxSumAfterPartitioning(self, A: List[int], k: int) -> int:
        
        #   edge case check
        if (A == None or len(A) == 0):
            return 0
        
        #   initializations
        n = len(A)
        maxSums = [0 for i in range(n)]
        
        #   for each index to update maxSums array
        for i in range(n):
            
            #   initialize maxElement to update max(arr[i-j+1 : i]) at each iteration
            maxElement = A[i]
            
            #   iterate over j and find max sum only if i-j+1 >= 0
            for j in range(1, k+1):
                if (i - j + 1 >= 0):
                    
                    maxElement = max(maxElement, A[i - j + 1])

                    #   use maxSums[i-j] only if i-j >= 0 and otherwise it is 0
                    if (i - j >= 0):
                        currentSum = (j * maxElement) + maxSums[i - j]
                    else:
                        currentSum = (j * maxElement) + 0
                    
                    #   update max sum
                    maxSums[i] = max(maxSums[i], currentSum)
         
        #   return the max sum partition at last index           
        return maxSums[n - 1]