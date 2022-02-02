
//Time Complexity O(m*n)
// Space Complexity O(m*n))
//Problem successfully executed on leetcode
//No problems faced while coading this.

#include<iostream>
#include<vector>
#include<queue>
#include<map>
#include<stack>
using namespace std;


class Solution {
public:
    int maximalSquare(vector<vector<char> >& matrix) {
        int n=matrix.size();
        int m=matrix[0].size();
        vector<vector<int> > dp(n+1,vector<int>(m+1,0));
        
        int maxi=0;
        for(int i=1; i<n+1;i++)
        {
            for(int j=1;j<m+1;j++)
            {
                if(matrix[i-1][j-1]=='1')
                {
                    int mini=min(dp[i-1][j-1],min(dp[i-1][j],dp[i][j-1]));
                    dp[i][j]=mini+1;
                    maxi= max(maxi,dp[i][j]);
                }
            }
        }
        return maxi*maxi;
    }
};