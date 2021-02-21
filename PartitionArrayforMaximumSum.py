# Time Complexity : O(NK)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using DP Approach. Since there are repeated subproblems for the previous partitions we use dp.
# Initialize a dp of length of array.
# Then we will iterate through the array and get the maxnum as the first element in the array
# Then we iterate upto the 1 to k partitions and check if the incoming element is going out of bounds
# Assign the maxnum to be the maximum between current maxnum and the incoming element
# Then check if current index and partition is going out of bounds if yes then we will get the maximum between the current value in dp array and current index - partition + maxnum * no of partitions
# Else we will get the maximum between the current value and maxnum * no of partitions


class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        if not arr:
            return None

        dp = [0] * len(arr)
        for i in range(len(arr)):
            maxnum = arr[i]
            for j in range(1, k + 1):
                if i - j + 1 >= 0:
                    maxnum = max(maxnum, arr[i - j + 1])
                    if i - j >= 0:
                        dp[i] = max(dp[i], dp[i - j] + maxnum * j)
                    else:
                        dp[i] = max(dp[i], maxnum * j)

        return dp[-1]