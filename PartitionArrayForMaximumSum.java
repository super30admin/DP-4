/*

Thought Process:
    There are repeatitive sub-problems. So it's a dp problem. We try to find the maximum between k=1,2,... added with dp[i-k] and proceed further. So, the last value in dp will be the maximum sum.
    
    T.C - O(nk) where n = size of array
    S.C - O(n)


*/

class PartitionArrayForMaximumSum {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if(arr.length == 0 || arr == null) return 0;
        int[] dp = new int[arr.length];
        
        for(int i=0; i<arr.length; i++){
            int max = arr[i];
            for(int j=1; j<=k && i-j+1 >= 0; j++){
                max = Math.max(arr[i-j+1], max);
                
                if(i-j>=0)
                    dp[i] = Math.max(dp[i], dp[i-j] + max*j);
                
                else
                    dp[i] = Math.max(dp[i], max*j);
            }
        }
        return dp[arr.length-1];
    }
}