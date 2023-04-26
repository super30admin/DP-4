class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        // at every element, create subrrays with it as the end element of lengths 1 to k as partitions upto length k are allowed,find max in that partition and sum would be parition length*max + sum of the remaining subarray,finally the last elemnt in the dp array would be the answer
        //TC-O(kn),SC-O(n)
        int n = arr.length;
        int[] dp = new int[n];
        dp[0]=arr[0];
        for(int i=1;i<n;i++){
            int max = arr[i];
            //subarrays of length 1 to k, subarrays start would be i-j+1,so make sure that its greater than 0
            for(int j=1;j<=k &&(i-j+1)>=0 ;j++){
                //get max in that subarray
                max=Math.max(max,arr[i-j+1]);
                if(i-j>=0){
                    dp[i]=Math.max(dp[i],(j*max)+dp[i-j]);
                }
                else{
                    dp[i]=Math.max(dp[i],(j*max));
                }
            }
        }
        return dp[n-1];
    }
}