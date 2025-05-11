'''
Took lot of support from the class to solve this problem.

SC: O(n)
TC: O(n*k)

'''
class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:

        n = len(arr)

        dp =[0 for i in range(n)]

        dp[0] = arr[0]

        for i in range(1,n):

            curr_max = 0

            for j in range(1, k+1):
                if i - j + 1 < 0:
                    break
                curr_max = max(curr_max, arr[i-j+1])

                if(i-j>=0):
                    dp[i]=max(dp[i], curr_max*j+dp[i-j])
                else:
                    dp[i] = max(dp[i], curr_max*j)

        return dp[n-1]

