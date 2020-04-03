//Time Complexity: O(n)
//Space Complexity: O(n)

class Solution {
    public int maximalSquare(char[][] matrix) {
        
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int max = 0; //for calculating max area
        
        int[][] dp = new int[m][n];
        
        //fill up the first row
        for(int i=0; i<m; i++)
        {
            if(matrix[i][0] == '1')
                dp[i][0] = 1;
            else
                dp[i][0] = 0;
            
            max = Math.max(max, dp[i][0]);
        }
        
         //fill up the first column
        for(int i=0; i<n; i++)
        {
            if(matrix[0][i] == '1')
                dp[0][i] = 1;
            else
                dp[0][i] = 0;
            
            max = Math.max(max, dp[0][i]);
        }
        
        for(int i=1; i<m; i++)
        {
            for(int j=1; j<n; j++)
            {
                if(matrix[i][j] == '1')
                {
                   dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1])+1;
                   max = Math.max(max, dp[i][j]);
                }
            }
        }
        
        return max * max;
    }
}
