// Time Complexity : O(nk) ; n- input array size , k - no. of partitions
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

public class PartitionArrayForMaximumSum {

    public int maxSumAfterPartitioning(int[] arr, int k) {

        int[] dp = new int[arr.length];

        dp[0] = arr[0];

        for(int i = 0; i < arr.length; i++){
            int max = dp[i]; //max in each partition of size k
            //exploring k partitions
            //i -j +1 >=0 - to do only max splits possible (breaching left bounds)
            for(int j = 1; j <= k && i-j+1 >= 0 ; j++){

                //calculate max by comparing with incoming element
                max = Math.max(max, arr[i-j+1]);

                //Overwrite same dp element based on current split value
                //on splitting there will be 2 terms - (curr split + rest)
                if(i-j + 1 > 0){
                    dp[i] = Math.max(dp[i], (max * j) + dp[i-j]);
                }else{
                    //when we are at 3rd element and have split of size 3
                    //ex- curr split [1,15,7] and rest []
                    dp[i] = Math.max(dp[i], (max * j));
                }
            }
        }

        return dp[dp.length - 1];
    }

}
