# Time: O(k*n)
# Space: O(n)
class Solution(object):
    def maxSumAfterPartitioning(self, arr, k):
        """
        :type arr: List[int]
        :type k: int
        :rtype: int
        """
        sm = []
        sm.append(arr[0])
        for i in range(1, len(arr)):
            mx = arr[i]
            curr_max = -1
            for j in range(i, max(-1, i-k), -1):
                mx = max(mx, arr[j])
                if j >= 1:
                    curr_max = max(curr_max, mx*(i-j+1)+sm[j-1])
                else:
                    curr_max = max(curr_max, mx*(i-j+1))
            sm.append(curr_max)
        #print(sm)
        return sm[len(sm)-1]
                
                
                
        
