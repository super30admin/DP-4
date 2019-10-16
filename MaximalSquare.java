// Time complexity - O(m*n)
// Space complexity - O(m+n)
// Tested in leetcode

class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        // return 0 if matrix is empty
        if(matrix.length == 0)
            return 0;
        int max = 0;
        
        // allocate space to store result of subproblems
        int[][] dp = new int[matrix.length+1][matrix[0].length+1];
        for(int i=1; i<=matrix.length; i++){
            for(int j=1; j<=matrix[0].length; j++){
                // skip if character at any location is 0 , as square cannot be foemed using that char
                if(matrix[i-1][j-1] == '0')
                    continue;
                
                // find min overlapping of squares in up,leftand diagonal direction and store into the dp array.
                int min = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]);
                dp[i][j] = min +1;
                max = Math.max(max,dp[i][j]);
            }
        }
        return max*max;
    }
}