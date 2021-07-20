class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        """DP Approach
        Time complexity-O(n)
        Space complexity-O(n)"""
        dparr=[0 for i in range(len(arr))]
        maxi=0
        dparr[0]=arr[0]
        for i in range(1, len(arr)):
            maxi=arr[i]
            for j in range(1, k+1):
                if i-j+1>=0:
                    maxi=max(maxi, arr[i-j+1])
                    if i-j>=0:
                        dparr[i]=max(dparr[i],dparr[i-j]+(maxi*(j)))
                    else:
                        dparr[i]=max(dparr[i],maxi*j)
                    
        return dparr[len(dparr)-1]