class Solution {//Time of O(KN) and space of O(N)
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int arrlen = arr.length ;
        int[] dp = new int[arrlen];
        int currMax = 0;
        
        //Iterate the elements 
        for(int  i = 0; i < arrlen ; i++){
            currMax = 0 ;
            //Iterate the window (k)
            for(int K = 1 ; K <=k && i - K + 1 >=0 ; ++K){
                currMax = Math.max(currMax,arr[i - K + 1]);
                dp[i] = Math.max(dp[i],(i >= k ? dp[i-K]:0)+ currMax * K);
                //System.out.print(dp[i] + " ");
            }
        }
        return dp[arrlen-1];
    }
}