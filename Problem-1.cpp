class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        int n = matrix.size();
        if (n == 0) return 0;
        int m = matrix[0].size();
        vector<vector<int> > dp(n + 1, vector<int>(m + 1));
        int maxSquare = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    dp[i + 1][j + 1] = min({dp[i][j], dp[i][j + 1], dp[i + 1][j]}) + 1;
                    maxSquare = max(maxSquare, dp[i + 1][j + 1]);
                }
            }
        }
        return maxSquare * maxSquare;
    }
};
