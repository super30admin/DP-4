// Time Complexity :O(nm)
// Space Complexity : O(nm)   
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        vector<vector<int>> dp(matrix.size()+1,vector<int>(matrix[0].size()+1,0));
        int max = 0;
        for(int i = 1;i<dp.size();i++){
            for(int j = 1;j<dp[0].size();j++){
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = min(dp[i-1][j],min(dp[i][j-1],dp[i-1][j-1])) + 1;
                    if(max < dp[i][j]) max = dp[i][j];
                }
            }
        }
        return max*max;
    }
};