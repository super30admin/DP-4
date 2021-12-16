class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int dp[] = new int[arr.length];


        int current, maxSoFar;
        dp[0] = arr[0];
        for(int i=1;i<arr.length;i++){
            maxSoFar = arr[i];
            current = 0;
            for(int j=1;j<=k;j++)
                if(i-j>=-1){
                    current = Math.max(current, maxSoFar*j + helper(dp,i-j));
                    maxSoFar = Math.max(maxSoFar, helper(arr,i-j));
                }
                else
                    break;


            dp[i] = current;
        }
        return dp[arr.length-1];
    }
    public int helper(int []arr, int k){
        if(k<0)
            return 0;
        return arr[k];
    }
}