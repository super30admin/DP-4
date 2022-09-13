// time complexity: O(n)
// space complexity: O(n)

//Identify the sub-problem, which'll make dp in linear manner

class maxSumAfterParti {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if(arr==null||arr.length==0) return 0;
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];
        for(int i=1; i<n; i++){
            int max = 0;
            for(int p=1; p<=Math.min(k,i+1); p++){

                //finding the max number among this particular partition
                max = Math.max(max,arr[i-p+1]);

                //calculating the value of that partition plus value of earlier sub-problem
                //with edge case in mind
                int valCurrPartition = max*p;
                if(i-p>=0){
                    valCurrPartition +=dp[i-p];
                }

                //finding the max value out of the all possible partition
                dp[i] = Math.max(dp[i], valCurrPartition);
            }
        }

        return dp[n-1];
    }
}