/**
 * Time Complexity : O(mn) where m is the number of rows and n is the number of columns 
 * Space Complexity : O(mn)
 */

public class MaximalSquare{
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0){return 0;}
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];                                                    
        int max = 0;
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(matrix[i-1][j-1] == '1'){                                                                
                dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;                            
                max = Math.max(dp[i][j], max);                                                      
                }
            }
        }
        return max*max;                                                         
        }
}