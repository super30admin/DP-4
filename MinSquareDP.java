public class MinSquareDP {
        //top to bottom dp
    //tc = m*n
  public static void main(String[] args)
  {
char[][] i = {{'1','0','1','0','0'},{'1','0','1','1','1'},
{'1','1','1','1','1'},{'1','1','1','1','1'}};
int c = maximalSquare(i);
System.out.println(c);

  }




    public static int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int max = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][]dp = new int[m+1][n+1];
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(matrix[i-1][j-1] == '1')
                {
                  dp[i][j] = 1+ Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1]));
                  max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max*max;
    }

}
