class Solution {
    public int maximalSquare(char[][] matrix) {
        //base
        if(matrix.length==0 || matrix== null) return 0;
        int n= matrix.length;
        int m= matrix[0].length;
        int[][] dp= new int[n][m];
        int len=0;
        for(int r=n-1; r>=0; r--){
            for (int c=m-1; c>=0; c--){
                if(matrix[r][c]=='1'){
                     
                    if(r==n-1 || c==m-1) {
                        dp[r][c] = matrix[r][c]-'0';
                        len= Math.max(len,dp[r][c]);
                        continue;
                    }
                    
                    dp[r][c]=dp[r][c+1]+1;
                    dp[r][c]=Math.min(dp[r][c],dp[r+1][c]+1);
                    dp[r][c]=Math.min(dp[r][c],dp[r+1][c+1]+1);

                    len= Math.max(len,dp[r][c]);
    
                }
            //    System.out.print(dp[r][c]+"  ");
            }
        //    System.out.println();
        }
        return len*len;
        
    }
}
//Timecomplexity - O(mn)
// space complexity- O(mn)