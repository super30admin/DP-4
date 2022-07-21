// Time Complexity : O(k*n) Time to go through the array and to go through k partitions each time for an element
// Space Complexity : O(n) Space to memorize the max sum until a particular element
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Couldn't think much about the solution until the class

class PartitionArrayMaxSum {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int [] dp = new int[n];
        dp[0] = arr[0];
        for(int i=1;i<n;i++){
            int max = arr[i];
            for(int j=1;j<=k && i-j+1>=0;j++){
                max = Math.max(max, arr[i-j+1]);
                int curr = 0;
                if(i-j>=0){
                    curr = j*max + dp[i-j];
                }
                else{
                    curr = j*max;
                }
                dp[i] = Math.max(dp[i],curr);
            }
        }

        return dp[n-1];
    }

    public static void main(String [] args){
        PartitionArrayMaxSum pams = new PartitionArrayMaxSum();
        System.out.println(pams.maxSumAfterPartitioning(new int[]{1,15,7,9,2,5,10}, 3));
    }
}