// Time Complexity - O(m^2*n^2)
// Space Complexity - O(1)
// BFS/DFS wont work because we need to find a square.
// Approach: Brute force
// Search for 1 in our matrix and once you come across first 1, move to the diagonal to get another 1.
// As you reach there, check rows and cols that are 1 within a range curr from i and j cell. 
// If range is within the cell, check their neighboirs further by running loop from i+curr range to i and j+curr to j 
// and if all are 1's in this range, we found the square, now set flag = 1.
// Otherwise, flag = 0 and square cant be expanded further

class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int max = 0, flag = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(matrix[i][j] == '1') {
                    int curr = 1;
                    flag = 1;
                    while(i+curr < m && j+curr < n && flag == 1) {
                        for(int k = i+curr; k>=i;k--) {
                            if(matrix[k][j+curr]=='0') {
                                flag = 0;
                            }
                        }
                        for(int k = j+curr; k>=j;k--) {
                            if(matrix[i+curr][k]=='0') {
                                flag = 0;
                            }
                        }
                        if(flag == 1) curr++;
                    }
                    max = Math.max(max,curr);
                }
            }
        }
        return max*max;
    }
}

// Dynamic Programming
// Time Complexity - O(mn)
// Space Complexity - O(mn)

class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m+1][n+1]; // First row and column is filled with 0
        int max = 0;
        for(int i=1;i<dp.length;i++) {
            for(int j=1;j<dp[i].length;j++) {
                if(matrix[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1; // minimum of the three sides 
                    max = Math.max(max,dp[i][j]); // max side of sq
                }
            }
        }
        return max*max; // area
    }
}