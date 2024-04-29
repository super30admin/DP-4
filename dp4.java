//Time O(NM) and space O(N)
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] dp = new int[n+1];
        int diagonal =0;

        int max =0;
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(matrix[i][j]=='1'){
                    int tem = dp[j];
                    dp[j] = Math.min(dp[j+1], Math.min(dp[j],diagonal))+1;
                    max= Math.max(max,dp[j]);
                    diagonal =tem;
                }else{
                    dp[j] = 0;
                }
            }
        }

        return max*max;
        
    }
}

//Time O(N) and space O(N)
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n+1];
       
        for(int i=0;i<n;i++){
            int max = 0;
            for(int j=1;j<=k && i-j+1>=0;j++){
                max = Math.max(max, arr[i-j+1]);
                int currVal = j*max;
                if(i-j>=0){
                    currVal = dp[i-j] + j * max;
                }
                dp[i] = Math.max(dp[i],currVal);
            }
        }

        return dp[n-1];
        
    }
}
