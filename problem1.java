public class problem1 {

    //brute force code :
    // Time Complexity: O(m^2)(n^2)
    //Space Complexity: o(1)
    public int maximalSquare1(char[][] matrix) {
        int m= matrix.length;
        int n= matrix[0].length;
        int max=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]=='1')
                {
                    int le=1;
                    boolean flag=true;
                    while(flag && i+le<m && j+le<n )
                    {
                        for(int k=i+le;k>=i;k--)
                        {
                            if(matrix[k][j+le] =='0')
                            {
                                flag=false;
                                break;
                            }
                        }
                        for(int k=j+le;k>=j;k--)
                        {
                            if(matrix[i+le][k]=='0')
                            {
                                flag=false;
                                break;
                            }
                        }
                        if(flag){le++;}
                    }
                    max= Math.max(max,le);
                }
            }
        }
        return max*max;
    }
    //optimized code :
    // Time Complexity: O(m*n)
    //Space Complexity: o(m*n)
    public int maximalSquare(char[][] matrix) {
        int m= matrix.length;
        int n= matrix[0].length;
        int max=0;
        int[][] dp= new int[m+1][n+1];
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(matrix[i-1][j-1]=='1'){
                    dp[i][j]= 1+Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1]));
                    max= Math.max(max, dp[i][j]); }
            }
        }
        return max*max;
    }
}
