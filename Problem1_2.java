//Time Complexity: O(m*n)
//Space Complexity: O(m*n)
//Code run successfully on LeetCode.

public class Problem1_2 {

    public int maximalSquare(char[][] matrix){
        
        if(matrix == null|| matrix.length == 0)
            return -1;
        
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        
        int[][] dp = new int[m+1][n+1];
        
        for(int i =1; i <m +1; i++)
        {
            for(int j =1; j <n +1; j++){
                
                if(matrix[i-1][j-1] == '1'){
                    
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                    max = Math.max(max,dp[i][j]);
                }
            }
        }
        return max*max;
    }
}
