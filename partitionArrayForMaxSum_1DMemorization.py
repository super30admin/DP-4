'''
Time Complexity: 0(n)
Space Complexity: 0(n)
'''

class Solution:
    
    def __init__(self):
        # initlize a 1D memorization list
        self.mem_1D = None
    
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        
        # initialize a mem_1D
        self.mem_1D = [None]*len(arr)
        
        # iterate the arr and fill-up the self.mem_1D
        for i in range(0,len(arr)):
            
            if i == 0:
                self.mem_1D[i] = arr[i]
                continue
            
            else:
                pairCount = 0
                maxEle = None
                
                while pairCount != k:
                    
                    # get maxEle
                    if pairCount == 0:
                        maxEle = arr[i] # 15
                    else:
                        if i-pairCount < 0: break
                        maxEle = max(maxEle,arr[i-pairCount])
                            
                    # pair + max(remainingSum)
                    pairSum = maxEle*(pairCount+1)  
                    remainingSum = 0
                    if (i-(pairCount+1)) >= 0:
                        remainingSum = self.mem_1D[i-(pairCount+1)]
                    
                    # update to the maxSum
                    if self.mem_1D[i] == None:
                        self.mem_1D[i] = (pairSum+remainingSum)
                    else:
                        self.mem_1D[i]= max((pairSum+remainingSum),self.mem_1D[i])
                    
                    pairCount += 1
                '''end of while loop'''
        '''end of for loop'''
        
        # print("memory1D is:\t",self.mem_1D)
        return self.mem_1D[-1]