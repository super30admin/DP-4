class MaxSumAfterPartitioning {
    //Time : n*k where n = size of input array, k= size of partition
    //space: O(n)
    public int maxSumAfterPartitioning(int[] arr, int k) {
        //if array is empty return zero
        if(arr.length ==0 || arr==null) return 0;
        //creating a dp array
        int[] dp = new int[arr.length];
        //element at index 0 can only have one partition so it is same as input array
        dp[0] = arr[0];
        //filling the dp array
        for(int i=1; i<dp.length; i++){
            //current max
            int max = arr[i];
            //for all the partition size
            for(int j=1; j<=k && i-j+1>=0; j++){
                //updating max for all partition size
                max = Math.max(max,arr[i-j+1]); max = Math.max(max,arr[i-j+1]);
                //if left partition exist for current partition size
                if(i-j>=0){
                    //update dp of current location
                    dp[i] = Math.max(dp[i], max*j+dp[i-j]);
                }
                else{   //if left partition doesn't exist for current partition size
                     //update dp of current location
                    dp[i] = Math.max(dp[i], max*j);
                }
            }
        }
       // return last element
        return dp[arr.length-1];
    }
}