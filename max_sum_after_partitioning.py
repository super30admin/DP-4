class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:

        ## T.C = O(n.n)
        ## S.C = O(n)

        n = len(arr)
        dp = [0]*n
        dp[0] = arr[0]

        for i in range(1, n):
            mx = arr[i] 
            
            for j in range(0, k):
                
                if i-j >= 0:
                    m1 = max(arr[i-j : i+1])
                    m2 = m1 * (j+1)
                    mx = max(mx, m2)

                if i-j-1 >= 0:
                    dp[i] = max(dp[i], dp[i-j-1] + mx)
                else:
                    dp[i] = max(dp[i], mx)                    

        return dp[-1]
                

        
