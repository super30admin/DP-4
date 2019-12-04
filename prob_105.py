#leetcode 1043
#space -O(n)
#time - O(k*n)
# algo : with a k window,we keep checking all the possible combintions that give highest sum in that window

class Solution(object):
    def maxSumAfterPartitioning(self, A, K):
        """
        :type A: List[int]
        :type K: int
        :rtype: int
        """
        # variables
        n = len(A)
        dp = [0 for i in range(n)]
        # logic
        for i in range(n):
            max_val = 0
            for j in range(1, K + 1):  # this is for the window of k elements for every element in the dp array
                if i - j + 1 < 0:  # case when jth value in array is out of bound
                    continue;
                max_val = max(max_val, A[i - j + 1])  # 1 and 2 and so on case --- max value in the window
                if i - j >= 0:
                    dp[i] = max(dp[i], dp[i - j] + max_val * j)  # populating values with that length of window
                else:  # case when previous element in the k window is out of bound
                    dp[i] = max(dp[i], max_val * j)
        return dp[n - 1]




