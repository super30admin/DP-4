// Time Complexity : 
/*                  Approach 1: BF: O(m^2.n^2) where m is the number of rows and n is the number of columns 
                    Approach 2: DP: O(mn) where m is the number of rows and n is the number of columns 
// Space Complexity : 
/*                  Approach 1: BF: O(1) Brute force 
                    Approach 2: DP: O(mn) where m is the number of rows and n is the number of columns 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : BFS/DFS didn't work
/* Your code here along with comments explaining your approach: Start looking for 1's. As you get the first 1, move to the diagonal to get another
1. As you reach there, check the rows and columns that are 1 within a range c from i and j cell. If the range is within the cell, check their
neighbors further by running the loop from i+c range to i and j+c range to j and if all are 1s in this range, implies square has been detected, flag it to 1.
If any violation occurs -=> 0 occurs implies square cannot be expanded further. Make the flag false.
*/

// BRUTE FORCE
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0){return 0;}
        int m = matrix.length, n = matrix[0].length;
        int max = 0, flag = 0;
        for(int i =0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == '1'){                                                            // 1 found
                    int c = 1;
                    flag = 1;                                                                       // Make the flag true
                    while(i+c < m && j+c < n && flag == 1){                                         // Till you reach out of bounds or your flag is true
                    for(int k = i+c; k >= i; k--){
                        if(matrix[k][j+c] == '0') {                                             // Violation occurs within i+c range
                            flag = 0;                                                           // Cant be a expanded to a square anymore
                            break;
                    }
                    }
                        for(int k = j+c; k >= j; k--){
                            if(matrix[i+c][k] == '0'){                                                  // Violation occurs in j+c range
                                flag =0;                                                        // Cant be expanded to a sqaure anymore
                                break;
                            }
                        }
                    if(flag == 1){
                        c++;                                                                    // Expand the range if you have found a sqaure till now, explore
                }
                }
                max = Math.max(max, c);                                                             // Maximum Side square keep
            }
        }
        }
        return max*max;                                                                     // Return Area of the square
        }
}

// DYNAMIC PROGRAMMING APPROACH
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0){return 0;}
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];                                                     // First row/column is full 0
        int max = 0;
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(matrix[i-1][j-1] == '1'){                                                                // If 1 found
                dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;                            // Get the minimum of the three sides since we are restricted to number to min no 1's we can get in either side till we get a 0
                max = Math.max(dp[i][j], max);                                                      // Store the max side of the square
                }
            }
        }
        return max*max;                                                                                     // Return the area
        }
}