"""
Approach: Dynamic programming

First of all when we look at the problem, we have to do three things:

1) Get all the combinations of a contiguous subarray of at most length k
2) Replace all elements of the subarrays with their respective max value
3) Sum all the elements in all the subarrays and return the maximum of the sums obtained

Here we will maintain a dp array of length equal to given array like this

 1  15  7  9  2  5  10
 ______________________
[ |    |  |  |  |  |   ]

Now at index 1 we will have the maximum sum obtained if the array was [1]
At index 2 we will have the maximum sum obtained if the array was [1,15]
At index 3 we will have the maximum sum obtained if the array was [1,15,7] and so on.

So our array at a point will look like this: [1,30,45, , , , ]

We are doing so that we do not have to calulate answer for that subarray again in a case if array had [1,15,7,9]. So one of the pair of at most size k that can be formed would be like this [1,15,7],[9]. Now answer for [1,15,7] can be obtained at index 3.

TC: O(n x k)
SC: O(n)

"""

class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        if arr == None or len(arr) == 0:
            return 0
        
        dp = [0] * len(arr)
        
        for i in range(len(arr)):
            maxi = float('-inf')
            
            for j in range(1, k + 1):
                if i-j+1 >= 0:
                    maxi = max(maxi, arr[i-j+1])
                    
                    if i >= j:
                        dp[i] = max(dp[i], dp[i - j] + maxi * j)
                    else:
                        dp[i] = max(dp[i], maxi * j)
                        
                else:
                    break
                    
        return dp[-1]