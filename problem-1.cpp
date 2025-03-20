// https://leetcode.com/problems/maximal-square/description/
// Time Complexity: O(n*m)
// Space Complexity: O(n*m)

class Solution {
    public:
        int maximalSquare(vector<vector<char>>& matrix) {
            int n = matrix.size();
            int m = matrix[0].size();
            vector<vector<int>> dp(n+1, vector<int>(m+1,0));
            int maxEle = 0;
            for(int i=n-1; i>=0; i--){
                for(int j=m-1; j>=0; j--){
                    if(matrix[i][j] == '1'){
                        dp[i][j] = 1 + min(dp[i+1][j+1], min(dp[i+1][j], dp[i][j+1]));
                        maxEle = max(maxEle, dp[i][j]);
                    }
                }
            } 
            return maxEle*maxEle;
        }
    };