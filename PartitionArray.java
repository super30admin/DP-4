// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class PartitionArray {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        //edge
        if(arr == null || arr.length == 0) return 0;
        int [] dp = new int[arr.length];

        for(int i = 0; i < dp.length; i++){
            int max = arr[i];
            //finding all partitions possible
            for(int j = 1; j <= k && i-j+1 >= 0; j++){
                //compare max w/element
                max = Math.max(max, arr[i-j+1]);
                if(i-j >= 0){
                    dp[i] = Math.max(dp[i], dp[i-j] + max * j);
                }
                else{
                    dp[i] = Math.max(dp[i], max * j);
                }
            }
        }
        //last element in dp will be max
        return dp[arr.length-1];
    }
}