public class PartitionArrayForMaxSum {
    // times o(nXk)
    //space o(n)
    //solution exists eleminating dp array.
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if(arr==null||arr.length==0){
            return 0;
        }
        int n=arr.length;
        int[] dp = new int[n];
        dp[0] =arr[0];
        //loop for entire array to fill
        for(int i=1; i<n;i++){
            // loop for partion, runs for the length of k
            // take a mav variable. as and when iterating,
            //compare with incoming element and pick the max element
            int max = arr[i];
            for(int j=1; j<=k && i-j+1>=0; j++){
                max = Math.max(max, arr[i-j+1]);
                // to fill dp[i] compute the max between current dp[i] and calculated value.
                //calculated value is,
                //j*max because if its single element subarray we multiply it by the times.
                //and if we are picking multiple elements, its the previously stored element at i-j
                if(i-j>=0){
                    dp[i]=Math.max(dp[i], dp[i-j]+j*max);
                }else{
                    dp[i]=Math.max(max, j*max);
                }
            }
        }
        return dp[n-1];

    }
}
