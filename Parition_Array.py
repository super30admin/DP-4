class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        n=len(arr)
        t=[0 for _ in range(n)]
        t[0]=arr[0]
        
        for i in range(n):
            maximum=t[i]
            for j in range(1,k+1):
                if i-j+1>=0:
                    maximum=max(maximum,arr[i-j+1])
                    if i-j>=0:
                        t[i]=max(t[i],maximum*j+t[i-j])
                    else:
                        t[i]=max(t[i],maximum*j)
                        
        return t[-1]
                    