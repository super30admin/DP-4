// Time Complexity : O(M*N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We will use dynamic programming to solve this problem.
//  We will create a dp matrix of the same size as the input matrix
//  where dp[i][j] will represent the length of the largest square that can be formed with the bottom right corner at (i, j). , Left , diagonal and down
//  We will iterate through the input matrix and whenever we encounter a '1', we will update the dp matrix at that position by taking the minimum of the three adjacent positions (left, diagonal and down) and adding 1 to it. This is because the length of the square that can be formed at that position will be limited by the smallest of the three adjacent positions.
//  We will keep track of the maximum length of the square found so far and return the area of that square at the end.
//  This approach has a time complexity of O(M*N) and a space complexity of O(M*N) due to the dp matrix. However, we can optimize the space complexity to O
class Solution {
    public int maximalSquare(char[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int max = 0;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n; j++) {

                if (matrix[i - 1][j - 1] == '1') {

                    dp[i][j] = 1 + Math.min(
                            dp[i - 1][j],
                            Math.min(dp[i][j - 1], dp[i - 1][j - 1])
                    );

                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        return max * max;
    }
}