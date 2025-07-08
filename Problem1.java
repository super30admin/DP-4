//Time Complexity : O(m*n)
// Space Complexity : O(n) : space used for the map to store anagrams
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Three line explanation of solution in plain english:
//1. we are using a 1d array to store the maximum square size ending at each cell, We have optimized on space by using a 1D array instead of a 2D array
//2. This is because we only need the current row and the previous row to calculate the maximum
//3. We iterate through the matrix from bottom to top and right to left, updating the dp array to store the maximum square size ending at each cell.


class Solution {
    public int maximalSquare(char[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        // Initialize max to 0 to keep track of the maximum square area found
        int max=0;
        //int[][] dp=new int[m+1][n+1];
        // Create a 1D array to store the maximum square size ending at each cell, We have optimized on space by using a 1D array instead of a 2D array
        // This is because we only need the current row and the previous row to calculate the maximum
        int[] dp=new int[n+1];
        // This is done to avoid overwriting values that are needed for the current calculation
        for(int i=m-1;i>=0;i--){
            // Initialize the diagonal to store the value of the previous diagonal cell
            int diagonal=0;
            // Iterate through the columns from right to left
            for(int j=n-1;j>=0;j--){
                // storing dp[j] in temp because we need its value for the next iteration
                int temp=dp[j];
                // If the current cell is '1', we get a square and the size of the square is 1 plus the minimum of the square sizes of the right, down, and diagonal cells
                if(matrix[i][j]=='1'){
                    dp[j]=1+Math.min(dp[j+1],Math.min(dp[j],diagonal));
                    // Update the maximum square area found so far
                    max=Math.max(max,dp[j]);
                // If the current cell is '0', we cannot form a square, so we set dp[j] to 0
                }else{
                    dp[j]=0;
                // Update the diagonal to the current value of dp[j] for the next iteration
                }diagonal=temp;
            }
        // If we found a square, return the area of the largest square found
        }return max*max;
    }
}