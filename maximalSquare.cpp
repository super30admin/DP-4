#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
We just keep one row of DP and move from left to right while updating each cell.
We also track the diagonal-up value from the previous row to calculate the square side.
This saves space and still gives us the correct biggest square ending at any cell.
*/
class Solution{
public:
    int maximalSquare(vector<vector<char>>& matrix){
        int m = matrix.size();
        int n = matrix[0].size();

        int max = 0;
        vector<int> dp(n+1, 0);
        int diagUp = 0;
        for(int i=1; i <= m; i++){
            for(int j = 1; j<=n; j++){
                int temp = dp[j];
                if(matrix[i-1][j-1] == '1'){
                    dp[j] = 1 + min(dp[j], min(dp[j-1], diagUp));
                    max = std::max(max, dp[j]);
                }else dp[j] = 0;
                diagUp = temp;
            }
        }
        return max*max;
    }
};
