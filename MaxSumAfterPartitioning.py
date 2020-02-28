# -*- coding: utf-8 -*-
"""
Created on Thu Feb 27 20:03:57 2020

@author: WELCOME
"""
"""
Time Complexity - O(N)
Space - O(N)
"""
class Solution:
    def maxSumAfterPartitioning(self, A: List[int], K: int) -> int:
        totalMax=0
        h={}
        def helper(index,total):
            nonlocal h
            if index in h:
                return h[index]+total
            if index==len(A):
                return total
            if index>=len(A):
                return 0
            m=A[index]
            newMax=0
            for i in range(index,index+K):
                if i>=0 and i<len(A):
                    m=max(m,A[i])
                    newMax=max(newMax,helper(i+1,total+m*(i+1-index)))
            h[index]=newMax-total
            return newMax
        return helper(0,0)