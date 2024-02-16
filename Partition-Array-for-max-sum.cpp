// Time Complexity : O(K*N)

// Space Complexity : O(N)

// Did this code successfully run on Leetcode : YES

// Appoarch: Recursion -> Dp

// 221. Maximal Square

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int helper(int idx, vector<int>& arr, int k,int n, vector<int>& dp){
        int len = 0,sum=0;
        int maxi = INT_MIN;
        int res = INT_MIN;
        if(idx == n) return 0;
        if(dp[idx] != -1) return dp[idx];
        for(int j=idx;j<min(n,idx+k);j++){
            len++;
            maxi = max(maxi,arr[j]);
            sum = len * maxi + helper(j+1,arr,k,n,dp);
            res = max(res,sum);
        }
        return dp[idx] = res;
    }
    int maxSumAfterPartitioning(vector<int>& arr, int k) {
        int n = arr.size();
        vector<int> dp(n+1,-1);
        return helper(0,arr,k,n,dp);
    }
};