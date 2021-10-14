// O(n*k) for iterating and populating whole dp array
// O(n) dp array same as size of array
// Idea here is to perform dp by checking maximum results in k possible options by iteratinf through previous k
// elements and adding the k*max at each dp element.
// last value of dp will provide maximum result.
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if(arr==null || arr.length==0) return 0;
        int [] dp = new int[arr.length];
        dp[0] = arr[0];
        for(int i = 1; i< dp.length; i++) {
            int max = dp[i];
            for(int j = 1; j<=k && i-j+1>=0; j++) {
                max = Math.max(max, arr[i-j+1]);
                if(i-j>=0) {
                    dp[i] = Math.max(dp[i], max* j + dp[i-j]);
                } else {
                    dp[i] = Math.max(dp[i], max* j);
                }
            }
        }
        return dp[dp.length-1];
    }
}