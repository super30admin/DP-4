//Time :(MN)
//SPace:(MN)
public class UniquePaths {

    int[][] dp;
    
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        dp[m-1][n-1] =1;
        return helper(0,0,m,n);
    }
    
    public int helper(int i,int j,int m,int n){
    
        // base 
        if(i>=m || j>=n) return 0;
        
        if(i==m-1 && j==n-1) return 1;
        
        if(dp[i][j] != 0)
            return dp[i][j];
       int right=0,down=0;
        // logic
        if(j+1 < n ){
            if(dp[i][j+1]==0){
                dp[i][j+1]= helper(i,j+1,m,n);
            }
            right = dp[i][j+1];
        }
            
        
        if(i+1<m){
            if(dp[i+1][j]==0)
                dp[i+1][j] = helper(i+1,j,m,n);
            down = dp[i+1][j] ;
        }
            
        dp[i][j] = right+down;
        return dp[i][j];    
    }
}
