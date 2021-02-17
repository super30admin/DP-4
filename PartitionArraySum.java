// Time Complexity : 0(nk)
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class PartitionArraySum {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if(arr == null || arr.length == 0)
            return 0;

        int[] dp = new int[arr.length];

        //move along arr
        for(int i=0;i<arr.length;i++){
            int max = arr[i];
            //put partitions
            //i-j+1 >= 0 to check boundary conditions for initial element
            for(int j=1;j<=k && i-j+1 >= 0;j++){
                //max between current max and incoming element
                max = Math.max(max, arr[i-j+1]);
                //i-j >= 0 to check boundary conditions for initial dps
                if(i -j >= 0)
                    dp[i] = Math.max(dp[i], dp[i-j] + max * j);
                else
                    dp[i] = Math.max(dp[i], max * j);
            }
        }

        return dp[arr.length-1];
    }
}