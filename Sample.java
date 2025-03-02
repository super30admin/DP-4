class Sample{
    /******************problem-1**************/
    //TC:0(M*N)
//SC:0(M*N)
    class Solution {
        public int maximalSquare(char[][] matrix) {
            if(matrix==null || matrix.length==0){
                return 0;
            }
            int m=matrix.length,n=matrix[0].length;
            int max=0;
            int[][]dp=new int[m+1][n+1];
            for(int i=1;i<m+1;i++){
                for(int j=1;j<n+1;j++){
                    if(matrix[i-1][j-1]=='1'){
                        dp[i][j]=Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
                        max=Math.max(max,dp[i][j]);
                    }
                }
            }
            return max*max;
        }
    }

    //TC:0(M*N)
//SC:0(N)
    class Solution {
        public int maximalSquare(char[][] matrix) {
            if(matrix==null || matrix.length==0){
                return 0;
            }
            int m=matrix.length,n=matrix[0].length;
            int max=0;
            int[]dp=new int[n+1];
            for(int i=0;i<m;i++){
                int temp=dp[0];
                for(int j=1;j<n+1;j++){
                    int prev=dp[j];
                    if(matrix[i][j-1]=='1'){
                        dp[j]=Math.min(dp[j-1],Math.min(dp[j],temp))+1;
                        max=Math.max(max,dp[j]);
                    }else{
                        dp[j]=0;
                    }
                    temp=prev;
                }
            }
            return max*max;
        }
    }
    /**********************PROBLEM-2****************/
//TC:0(N*K)
//SC:0(N)
    class Solution {
        public int maxSumAfterPartitioning(int[] arr, int k) {
            if(arr.length==0 || arr==null || k==0){
                return 0;
            }
            int n=arr.length;
            int[] dp=new int[n];
            dp[0]=arr[0];
            for(int i=1;i<n;i++){
                int max=arr[i];
                for(int j=1;j<=k && i-j+1>=0;j++){
                    max=Math.max(max,arr[i-j+1]);
                    if(i-j>=0){
                        dp[i]=Math.max(dp[i],dp[i-j]+j*max);
                    }else{
                        dp[i]=Math.max(dp[i],j*max);
                    }

                }
            }
            return dp[n-1];
        }
    }
}