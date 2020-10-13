//TC: O(mn) where m => row and n => col
//SC: O(mn)

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;

        if(rows == 0) 
            return 0;

        int cols = matrix[0].length;
        int[][] dp = new int[rows + 1][cols + 1];
        int max = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                System.out.println(Character.getNumericValue(matrix[i-1][j-1]));
                //if the char at i,j is 1 then we go and fetch the adjacent minimum value and add 1 to it and parallely keep a track of the max value
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]))+1;
                    max = Math.max(max, dp[i][j]);
                }
                
            }
        }
        
        return max*max;
        
    }
}