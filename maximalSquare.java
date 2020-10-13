//Space Complexity: O(mn)
//Did it run on leetcode: yes

class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return 0;
        
        int max = Integer.MIN_VALUE;
        int[][] dp = new int[matrix.length][matrix[0].length];
        
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                
                if(i==0 || j==0){
                    dp[i][j] = matrix[i][j] - '0';
                }
                else{
                    if(matrix[i][j] == '0')
                        dp[i][j] = 0;
                    else
                        dp[i][j] = Math.min(dp[i][j-1],Math.min(dp[i-1][j-1],dp[i-1][j]))+1; 
                }
                
                if(dp[i][j]>max)
                    max = dp[i][j];
            }
        }
        
        return max*max;
    }
}
