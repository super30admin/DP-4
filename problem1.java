// Time Complexity : O(n*m)
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach : I used a dp matrix, it stores the maximum length (side) of square that can be made from a particular index. I go from top to down so I check the left, up and diagonal - each will tell me if I can make a square or not and of what size. From these I select the minimum as I only care about the minimun side for this problem and add 1 if my currently element is 1. If it's a 0 I continue. Each point I store the max value of side that I can get and finally just return its square. 

class Solution {
    public int maximalSquare(char[][] matrix) {
        int[][] board = new int[matrix.length][matrix[0].length];
        int max = 0;
        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix[0].length; j++){
                if(matrix[i][j]-'0'==0)continue;
                int left = j>0?board[i][j-1]:0;
                int up = i>0?board[i-1][j]:0;
                int diag = j>0 && i>0?board[i-1][j-1]:0;
                board[i][j] = Math.min(left, Math.min(up, diag)) + 1;
                max = Math.max(max, board[i][j]);
            }
        }
        return max * max;
    }
}