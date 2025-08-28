//Time Complexity:O(n*k)
//Space Complexity:O(n)
#include<iostream>
#include<vector>
using namespace std;
class Solution {
public:
    int maxSumAfterPartitioning(vector<int>& arr, int k) {
        int n = arr.size();
        vector<int>dp(n+1,0);
        for(int i=1;i<=n;i++){
            int maxi=0;
            for(int m=1;m<=k;m++){   
                if(i-m >=0 ){
                    maxi = max(maxi,arr[i-m]);
                    dp[i] = max(dp[i], dp[i-m] + maxi*m);
                }
            }
        }
        return dp[n];
    }
};