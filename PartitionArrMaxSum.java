class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp= new int[arr.length];
        for(int i=0; i<arr.length; ++i){
                int maxx= 0;
            for(int j=1; j<=k && i-j+1>=0; j++){
            
                maxx=Math.max(arr[i-j+1], maxx);
                dp[i] = Math.max(dp[i], (i >= j ? dp[i - j] : 0) + maxx * j);
            }
        }
        return dp[arr.length-1];
    }
}
//time- O(nk)
//space- O(n)