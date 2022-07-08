// Time Complexity : O(m * n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes

// Three line explanation of solution in plain english
/* Build a DP array to store the length of maximal square that can be formed using current cell.
 * Iterate over i/p matrix, if current value is '1' then compute the DP value for current cell by taking minimum of
 * (left cell, top cell and top-left diagonal cell) and add 1 to it.
 * At the end retun the max dp value.
 */

class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        if (matrix.size() == 0)
            return 0;
        
        int m = matrix.size();
        int n = matrix[0].size();
        
        int max = 0;
        int dp[n + 1];
        
        for (int j = 0; j <= n; j++)
        {
            dp[j] = 0;
        }
        
        int prev = 0;
        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                if (matrix[i - 1][j - 1] == '1')
                {
                    // Store the diagonal value for future computation.
                    int temp = dp[j];
                    dp[j] = std::min(dp[j - 1], std::min(prev, dp[j])) + 1;
                    prev = temp;
                    
                    max = std::max(max, dp[j]);
                }
                else
                {
                    dp[j] = 0;
                }
            }
        }
        
        return max * max;
    }
};