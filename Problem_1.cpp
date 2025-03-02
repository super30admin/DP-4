// Author: Subhed Chavan
// Batch: December 24
// Problem Statement: Maximal Square
// Approach: Dynamic Programming
// Time Complexity: O(M * N)
// Space Complexity: O(N)

class Solution {
    public:
        int maximalSquare(vector<vector<char>>& matrix) {
            if (matrix.empty() || matrix[0].empty()) {
                return 0;
            }
    
            int m = matrix.size();
            int n = matrix[0].size();
            int maxSide = 0;
            vector<int> dp(n + 1, 0);  
            for (int i = 0; i < m; i++) {
                int temp = dp[0];
                for (int j = 1; j <= n; j++) {
                    int prev = dp[j];
                    if (matrix[i][j - 1] == '1') {
                        dp[j] = min({dp[j - 1], dp[j], temp}) + 1; 
                        maxSide = max(maxSide, dp[j]);  
                    }
                    else {
                        dp[j] = 0;  
                    }
                    temp = prev; 
                }
            }
    
            return maxSide * maxSide;  
        }
    };
    