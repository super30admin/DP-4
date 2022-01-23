class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0; //base case where if its a null matrix, we return 0;
        int m = matrix.length; // we take an integer variable m which stores the no. of rows
        int n = matrix[0].length; // we take the integer variable n which stores the no. of cols
        int[][] dp = new int[m + 1][n + 1]; //we create a 2d array with name dp of size m+1 and n+1. we take +1 extra to store the 0's of rows and cols
        int max = 0;// we take an integer variable called as max which is initialized to 0 which stores the size of the maximal square.
        for(int i = 1; i < m + 1; i++) { //we go through all the elements in the row starting from 1 until m+1
            for(int j = 1; j < n + 1; j++) { //we go through all the elements in the col starting from 1 until n+1
                if(matrix[i - 1][j - 1] == '1') { //if the location of the matrix is having a value of 1. we took i - 1 and j -1  because we have added new row and col in the dp array but that is not actually present in the matrix given to us.
                    dp[i][j] = Math.max(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1; // we take the min of the value around it and add 1 to it as the value of i - 1 and j - 1  is 1.
                    max = Math.max(max, dp[i][j]); // we take the max by coming the value of the max and the value at dp[i][j]
                }
            }
        }
        return max * max; // in the end, since we have to return the size of the square, we multiply max with max and return;
    }
}
//tc and sc - O(m*n)