// TC: o(m*n) SC: o(n)
class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int m = matrix.length; int n = matrix[0].length;
        int [] dp = new int[n+1];
        int max = 0;
        for(int i=m-1;i>=0;i--){
            int diagDown = 0;
            for(int j=n-1;j>=0;j--){
                if(matrix[i][j] == '1'){
                    int temp = dp[j];
                    dp[j] = 1+ Math.min(dp[j], Math.min(dp[j+1], diagDown));
                    max = Math.max(max,dp[j]);
                    diagDown = temp;
                } else {
                    dp[j] = 0;
                }
                
            }
        }
        return max*max;
    }
}
