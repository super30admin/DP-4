class PartitionArray {
    //TC is O(n^2)
    //SC is O(n)
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int max = arr[0];
        int[] dp = new int[arr.length];
        dp[0]=arr[0];
        for(int i=1; i<n;i++){
            max = arr[i];
                for(int j=1; j<=k && i-j+1 >= 0;j++){
                    max = Math.max(max,arr[i-j+1]);
                    int curr;
                    if(i-j>=0){
                        curr = j*max+dp[i-j];
                    }else{
                        curr = j*max;
                    }
                    dp[i]=Math.max(curr, dp[i]);
                }
        }
        return dp[n-1];
    }
}