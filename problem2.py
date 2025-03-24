# Time Complexity : O(nk)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO

# Your code here along with comments explaining your approach

class TopDownSolution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        memo = [-1 for i in range(len(arr))]

        def recurse(pivot):
            # base
            if pivot >= len(arr):
                return 0
            
            if memo[pivot] != -1:
                return memo[pivot]
            
            # logic
            max_total = 0
            max_seen = arr[pivot]

            for i in range(pivot, pivot + k):
                if i < len(arr):
                    max_seen = max(max_seen, arr[i])
                    par_sum = (i - pivot + 1) * max_seen
                    par_total = par_sum + recurse(i+1)
                    max_total = max(max_total, par_total)
            
            memo[pivot] = max_total
            return memo[pivot]
        
        return recurse(0)