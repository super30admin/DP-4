//Time-O(rows*colummns)
//Space-O(columns)
class Solution {
   public int maximalSquare(char[][] matrix) {
    if(matrix == null || matrix.length ==0|| matrix[0].length == 0) return  0;
    
    int[] dp = new int[matrix[0].length +1];
    int max = 0;
    int tmp1 = 0;
    int tmp2 = 0;
    
    for(int i=0; i< matrix.length; i++)
    {
        tmp1 = 0;
        for(int j=0; j< matrix[0].length; j++)
        {
            tmp2 = dp[j+1];
                                
            if(matrix[i][j] == '1')
            {
                dp[j+1] = Math.min(tmp1, Math.min(dp[j], dp[j+1])) + 1;
                max = Math.max(max, dp[j+1]);
            }
            else
            {
                dp[j+1] = 0;
            }
            
            tmp1 = tmp2;
        }
    }
    
    return max*max;
}
}
