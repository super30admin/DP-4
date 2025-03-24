// Time Complexity: O(m*n)
// Space Complexity: O(m*n)
// Did this code successfully run on Leetcode : Yes

// Approach:
// 1. Create a dp matrix of size m*n where dp[i][j] represents the side length of the maximum square whose bottom right corner is at (i, j).
// 2. If the current element is '1', then check if it is the first row or first column. If yes, then dp[i][j] = 1.
// 3. If it is not the first row or first column, then check the minimum of the three elements above, left and diagonal to the current element and add 1 to it.
// 4. Update the maxSide with the maximum of the current element and maxSide.
// 5. Return maxSide * maxSide as the area of the maximum square.

class Solution {
    public:
        int maximalSquare(vector<vector<char>>& matrix) {
            int m = matrix.size();
            int n = matrix[0].size();
            vector<vector<int>> dp(m, vector<int>(n, 0));
            int maxSide = 0; 
    
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(matrix[i][j] == '1'){
                        if(i == 0 || j == 0){
                            dp[i][j] = 1;
                        }
                        else{
                            dp[i][j] = min({dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]}) + 1;
                        }
                        maxSide = max(maxSide, dp[i][j]);
                    }
                }
            }
            return maxSide * maxSide;
        }
    };