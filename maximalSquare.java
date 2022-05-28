/*
Problem: https://leetcode.com/problems/maximal-square/
*/

// Approach 1: Brute force
// TC: O(m * n) ^ 2
// SC: O(1)
// TC: O(m * n)
// SC: O(m * n)
class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int maxLen = 0;
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (matrix[i][j] == '1') {
                    int inc = 1;
                    boolean allOnesSoFar = true;
                    while (i + inc < n && j + inc < m && allOnesSoFar) {
                        // check if column is all ones
                        for (int k = i; k <= i + inc; ++k) {
                            if (matrix[k][j + inc] == '0') {
                                allOnesSoFar = false;
                                break;
                            }
                        }
                        // check if row is all ones
                        if (allOnesSoFar) {
                            for (int k = j; k <= j + inc; ++k) {
                                if (matrix[i + inc][k] == '0') {
                                    allOnesSoFar = false;
                                    break;
                                }
                            }
                        }
                        if (allOnesSoFar) {
                            ++inc;
                        }
                    }
                    maxLen = Math.max(maxLen, inc);
                }
            }
        }
        
        return maxLen * maxLen;
    }
}

// Approach 2: DP
// TC: O(m * n)
// SC: O(m * n)
class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int dp[][] = new int[n+1][m+1];
        int maxLen = 0;
        
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                if (matrix[i-1][j-1] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }
        
        return maxLen * maxLen;
    }
}

// Approach 3: DP - space optimized
// TC: O(m * n)
// SC: O(m)
class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int dp[] = new int[m+1];
        int maxLen = 0;
        // To keep track of dp[i][j]
        int cur = 0;
        // To keep track of dp[i-1][j-1]
        int prev = 0;
        
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                cur = dp[j];
                if (matrix[i-1][j-1] == '1') {
                	// We will get the element at position dp[i][j-1] using dp[j-1]
                	// We will get element at position dp[i-1][j] using dp[j]
                	// Dp[i-1][j-1] would have been at dp[j-1] and would have been overwritten
                	// So we maintain cur and prev to track it.
                    dp[j] = 1 + Math.min(prev, Math.min(dp[j], dp[j-1]));
                    
                } else {
                	// We will have to explicitly set this to 0.
                	// In the prev case, dp[][] would be filled with 0 automatically but here it would get overwritten
                    dp[j] = 0;
                }
                maxLen = Math.max(maxLen, dp[j]);
                prev = cur;
            }
        }
        
        return maxLen * maxLen;
    }
}
