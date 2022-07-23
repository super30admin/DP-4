# Time Complexity: O(n*k)
# Space Complexity: O(n)

# Dp solution
# find all posiible partition at some element
# put maximum  of all possible partition at that place
class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        n = len(arr)
        dp = [0]*n
        dp[0] = arr[0]
        maxx =0
        for i in range(1,n):
            # set maximum to the incoming ele
            maxx = arr[i]

            # run the loop for k times, k is possible partition
            for j in range(1,k+1):
                if i-j+1 >=0:
                    # first we have alsredy set the maximum ith element
                    # if any other element in particular partition is higher that ith ele, that set that as max
                    # and make all element same as max and add tham + other partition, which is our curr partition.
                    # curr = sum of curr partition + repeted subproblem result  
                    maxx = max(maxx, arr[i-j+1])
                    curr = 0
                    
                    if i - j >=0:
                        curr = j*maxx + dp[i-j]
                    else:
                        curr = j*maxx
                   
                    dp[i] = max(dp[i],curr)
                
        return dp[n-1]
        
        