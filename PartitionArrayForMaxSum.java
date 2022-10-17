public class PartitionArrayForMaxSum {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];
        for(int i=1;i<n;i++){
            int max = arr[i];
            for(int j=1;j<=k && i-j+1>=0;j++){ // j - length of the partition
                max = Math.max(max, arr[i-j+1]); // i-j+1 - the previous element
                int curr = 0;
                if(i-j>=0) curr = j*max+dp[i-j]; 
                else curr = j*max; // k length partition is taken with no elements left in array
                
                dp[i] = Math.max(dp[i], curr);
            }
        }
        return dp[n-1];
    }
}

// Time complexity - O(kn)
// Space complexity - O(n)
