#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
We use a bottom-up dp array to track max sum up to each index.
For every index i, we check all partitions of size up to k ending at i.
We calculate the contribution from the max element and update dp[i] accordingly.
*/
class Solution{
public:
    int maxSumAfterPartitioning(vector<int>& arr, int k){
        int n = arr.size();
        vector<int> dp(n, 0);
        dp[0] = arr[0];

        for(int i = 1; i < n; i++){
            int currMax = 0;
            for(int j = 1; j <= k && i - j + 1 >= 0; j++){
                currMax = max(currMax, arr[i - j + 1]);
                if(i - j >= 0){
                    dp[i] = max(dp[i], currMax*j + dp[i-j]);
                }
                else dp[i] = max(dp[i], currMax*j);
            }
        }
        return dp[n-1];
    }
};
