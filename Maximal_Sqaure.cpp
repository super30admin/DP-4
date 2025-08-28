//Time Complexity :O(m*n)
//Space Complexity :O(n)
#include<iostream>
#include<vector>
using namespace std;
class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        int m = matrix.size(),n = matrix[0].size(),maxi = 0,x=0;
        vector<int> dp(n + 1, 0);
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                int temp = dp[j];
                if(matrix[i-1][j-1] == '1'){
                    dp[j] = 1 + min(dp[j],min(dp[j-1],x));
                    maxi = max(maxi,dp[j]);
                } else {
                    dp[j] = 0;
                }
                x=temp;
            }
        }
        return maxi*maxi;
    }
};