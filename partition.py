class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        #TC O(n *k)
        # TC O(n)
        
        size = len(arr);
        # if size == 1:
        #     return arr[0]
        dp = [0]*size;
        m = arr[0]
        for i in range(1, k):
            m = max(m,arr[i])
            dp[i] = m * (i + 1); # k = 1 :*1 , k = 2, :*2, k =3 , :*3
        print(dp)
        dp[0] = arr[0]
        
        partionMax = 0;
        for i in range(k, size):
            partionMax = arr[i];
            
            #traverse all combi
            for partSize in range(1 ,k+1):
                partionMax = max(partionMax, arr[i - partSize + 1]);
                dp[i] = max(dp[i-partSize]+( partionMax*partSize) , dp[i])
        print(dp)
        return dp[size - 1]
                
            
            
         
