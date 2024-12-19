class Problem1 {
    int max = 0;
    //TC: O(M*N)
    //SC: O(M*N)
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        //solve for the smallest subProblem
        //Arrays.fill(matrix[0],0);
        // for the bigger subProblem get the minimum of subproblems around and add 1 to it
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]))+1;
                    max =  Math.max(dp[i][j],max);
                }

            }
        }

        return max*max;
    }
}