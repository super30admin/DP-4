// Time Complexity : O(M*N)

// Space Complexity : O(M*N)

// Did this code successfully run on Leetcode : YES

// Appoarch: Recursion -> Dp

// 221. Maximal Square

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        int m = matrix.size();
        int n = matrix[0].size();
        vector<vector<int>> dp(m+1,vector<int>(n+1));
        int maxLen = 0;
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(matrix[i][j] == '1'){
                    dp[i][j] = 1 + min(dp[i][j+1],min(dp[i+1][j],dp[i+1][j+1]));
                    maxLen = max(maxLen,dp[i][j]);
                }
            }
        }
        return maxLen*maxLen;
    }
};