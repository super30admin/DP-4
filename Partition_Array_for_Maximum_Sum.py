class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        """
        Partition Array for Maximum Sum
        Time complexity : O(N)
        Space complexity : O(N)
        """
        
        
        self.final  = [0,arr[0]]
        
        for i in range(1,len(arr)):
            val = 0
            for j in range(k):
                if i-j >= 0:
                    # print(i,j)
                    # print(arr[i-j:i+1])
                    val = max(max(arr[i-j:i+1])*(j+1) + self.final[-1-j],val)
                    print(val)
                    
            self.final.append(val)
        return self.final[-1]
        
#         self.dp = {}
#         self.max = 0
#         self.q = deque([(0,0)])
        
#         while self.q:
#             temp = len(self.q)
#             for j in range(temp):
#                 node = self.q.popleft()
#                 index = node[0]
#                 sum_ = node[1]
                
#                 if self.dp.get(index) is not None and self.dp[index] > sum_:
#                     continue
#                 self.dp[index] = sum_
#                 for i in range(k):
#                     if len(arr[index:min(index+i+1,len(arr))]) == 0:
#                         continue
#                     self.q.append((index+i+1, sum_ + (max(arr[index:min(index+i+1,len(arr))]) * (i+1))))
#         return self.dp[len(arr)]

        
#         def recur(index,final_):
#             # print(index,final_)
#             if index >= len(arr):
#                 self.max = max(self.max,final_)
                
#             if self.dp.get(index) is not None and self.dp[index] > final_:
#                 return
#             self.dp[index] = final_
            
#             for i in range(k):
#                 if len(arr[index:min(index+i+1,len(arr))]) == 0:
#                     return
#                 recur(index+i+1, final_ + (max(arr[index:min(index+i+1,len(arr))]) * (i+1)))
                
#             return
        
#         recur(0,0)
#         return self.dp[len(arr)]
            