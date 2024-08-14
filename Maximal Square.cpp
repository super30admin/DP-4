//time: O(m*n)
//space: O(n+1) ~ O(n)/O(col)
class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        int result = 0;
        int m = matrix.size();
        int n = matrix[0].size();
        vector<int> dp(n+1,0);
        int temp, prevTemp, curr;
        for(int i = 0; i < m; i++) {
            temp = 0;
            for(int j = 0; j < n; j++) {
                curr = matrix[i][j] - '0';
                prevTemp = dp[j+1];
                if(curr == 1) {
                    temp = min(temp, prevTemp);
                    dp[j+1] = min(dp[j], temp) + 1;
                }
                else dp[j+1] = 0;
                result = max(result, dp[j+1]);
                temp = prevTemp;
            }
        }
        return result*result;
    }
};