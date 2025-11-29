// Time Complexity : O(mn)
// Space Complexity :O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : i am a bit fuzzy on the logic.

/*
Approach
we have given 2 approaches here,but this explaination is for the tabulation 

so we are using the tabulation bottom up dp, we create a new dp of size one bigger then the original matrix on both the size, we do that so this
Math.min(dp[i][j + 1], Math.min(dp[i + 1][j], dp[i + 1][j + 1])) does not fail at the edges

we start itteration for the bottom right and build the matrix from there we also keep track of the max

during itteration we check if matrix[i][j] is 1 we compare all the connected postions take the min from that add add 1
if matrix[i][j] is 0 we also fill the dp matrix as 0 for that postion 
*/

//Tabulation
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i][j + 1], Math.min(dp[i + 1][j], dp[i + 1][j + 1]));
                    max = Math.max(max, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return max * max;
    }
}

// Brute force
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    int le = 1;
                    boolean flag = true; // if 0 is found this flag is false
                    while (i + le < m && j + le < n && flag) {
                        for (int k = i + le; k >= i; k--) {
                            if (matrix[k][j + le] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        for (int k = j + le; k >= j; k--) {
                            if (matrix[i + le][k] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            le++;
                        }
                    }
                    max = Math.max(max, le);
                }

            }
        }
        return max * max;
    }
}