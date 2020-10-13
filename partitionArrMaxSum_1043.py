# // Time Complexity :O(n*k)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Yes, need to be better at resolving 'out of index' errors

# // Your code here along with comments explaining your approach
# create a dp array and start filling it by the following example:
# at 2 in arr[1,15,7,9,2,5,10]:
# val @ prev index viz max sum considering arr([1,15,7,9]) and [2] = 54 + 2 * 1 = 56, where 2 is the current maximum of the split and 1 is the length of subarray 
# simi, [1,15,7] and [9, 2] = 45 + 9*2 = 63
# simi, [1,15] and [7, 9, 2] = 30 + 9*3 = 57
# can;t go beyond that as k >3 hence max of (56,63,57) = 63 and add the value to dp
# only going back k steps at every point in the dp array

class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        
        if arr == None or len(arr)==0:
            return 0

        dp = [0]*len(arr)

        for i in range(len(arr)):
            mx = float('-inf')
            for j in range(1,k+1): 
                if i-j+1 >= 0:
                    mx = max(mx, arr[i-j+1])
                    if i >= j:
                        dp[i] = max(dp[i], dp[i-j]+mx*j)
                    else:
                        dp[i] = max(dp[i], mx*j)
        # print(dp)
        return dp[len(arr)-1]
                
                