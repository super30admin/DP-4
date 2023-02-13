#Time Complexity: O(m*n)
#Space Complexity: O(n)
#Did it run on leetcode: Yes

def maxSumAfterPartitioning(self, A: List[int], K: int) -> int:
        
        def recur(arr, start, memo):
            if start == len(arr):
                return 0
            
            cur_max = float('-inf')
            res = 0
            for i in range(K):
                if start+i == len(arr):
                    break
                cur_max = max(cur_max, arr[start+i])
                if start+i+1 in memo:
                    res = max(res, (i+1)*cur_max + memo[start+i+1])
                else:
                    res = max(res, (i+1)*cur_max + recur(arr, start+i+1, memo))
            memo[start] = res
            return res
        
        memo = {}
        recur(A, 0, memo)
        return memo[0]