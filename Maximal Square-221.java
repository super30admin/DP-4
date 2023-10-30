//Time Complexity:O(mn)
//Space Complexity: O(n)
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix==null || matrix.length==0){
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[] dp = new int[n+1];
        int max=0;
        for(int i=1; i<m+1; i++){
            int temp=dp[0];
            for(int j = 1; j<n+1; j++){
                int prev = dp[j];
                if(matrix[i-1][j-1]=='1'){
                   dp[j] = 1 + Math.min(dp[j-1],Math.min(dp[j],temp));
                   max= Math.max(max,dp[j]);
                }
                else{
                    dp[j]= 0;
                }
                temp = prev;
            }
        }
        return max*max;        
    }
}



