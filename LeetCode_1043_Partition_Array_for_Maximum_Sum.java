class Solution{
    public int maxSumAfterPartitioning (int[] arr, int k) {
        if(arr.length ==0 || arr == null || k ==0) return 0;
        
        int n = arr.length;
        int[] dp = new int[n];

        for(int i =0; i< n; i++)
        {
            int max = arr[i]; // this will be initialized to exisitng value of arr.
            for(int j =1; j<=k && i-j+1 >=0; j++) //second check for out of bound on left side.
            {
                if(i-j >=0)
                {
                    //within bound
                    dp[i] = Math.max(dp[i], max*j+ dp[i-j]);
                }
                else{
                    dp[i] = Math.max(dp[i], max*j);
                }
            }
        }
        return dp[n-1];
    }
}