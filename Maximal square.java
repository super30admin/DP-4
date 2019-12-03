TC:O(mn)
SC:O(mn)

68 / 68 test cases passed.
Status: Accepted
Runtime: 4 ms

Approach:  We make another dp matrix and fill it with values corresponding to the values in matrix. If corresponding value is zero, we skip.
If it is 1, we will fill each position with minimum of all three elements(top, left and top left) +1 and keep doing it. Result will be max 
value squared of the dp matrix.


class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0) return 0;
        int max =0;
        int row= matrix.length+1;
        int col = matrix[0].length+1;
        int[][] dp = new int[row+1][col+1];
        for(int i=1;i< row; i++){
            for(int j=1; j< col;j++){
                if(matrix[i-1][j-1]=='1'){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]), dp[i-1][j-1])+1;
                    if(max<dp[i][j]) max = dp[i][j];
                }
            }
        }
        // System.out.println(max);
       return max*max;
  }
}
