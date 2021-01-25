public class Solution {
    public int MaximalSquare(char[][] matrix) {
        int rows = matrix.Length, cols = matrix[0].Length;
        int[][] dp = new int[rows][];
        int maxsqlen =0;
        for(int i=0;i<rows;i++)
        {
            dp[i] = new int[cols];
            for(int j=0;j<cols;j++)
            {
                if(matrix[i][j]=='0')
                {
                    continue;
                }
                if(i==0 || j==0)
                {
                    dp[i][j]=1;
                }
                else if(helper(matrix,i,j))
                {
                    dp[i][j]= Math.Min(dp[i-1][j-1],Math.Min(dp[i][j-1],dp[i-1][j])) +1;
                }
                else
                {
                    dp[i][j] =1;
                }
                
                maxsqlen = Math.Max(maxsqlen,dp[i][j]);
                }
            }
        
        return maxsqlen * maxsqlen;
        
    }
    
    private bool helper(char[][] m,int i,int j) =>
    
        m[i][j-1]=='1' && m[i-1][j-1] == '1' && m[i-1][j] == '1';
    }
​
