//TC - O(nm);
//SC - O(m);
//LC - 221

class Solution {
    public int maximalSquare(char[][] matrix) {
        
        int max=0;
        int n = matrix.length;
        int m = matrix[0].length;
        int []dp = new int[m+1];
        int temp=0,prev=0;
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                temp = dp[j];
                if(matrix[i-1][j-1]=='1'){
                    dp[j] = Math.min(dp[j-1], Math.min(dp[j],prev))+1;
                    
                    max = Math.max(max,dp[j]);
                }
                else{
                    dp[j]=0;
                }
                prev=temp;
            }
        }
        
        return max*max;
    }
}