// Time Complexity : O(nk)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Main {
    public static int maxSumAfterPartitioning(int[] arr, int k) {
        // null case
        if (arr.length == 0)
            return 0;
        int n = arr.length;
        // dp array
        int[] dp = new int[n];
        // go through each element and divide the array in such a manner that we can
        // get maximum value
        for (int i = 0; i < n; i++) {
            // here we get maximum element in the partition and multiply it with it length
            // and add
            // previous partitions maximum value that we are getting from the dp array
            // we do this step for 1->k times as our maximum partition is k
            // intiallialy max is number itself as parition size is 1
            int max = arr[i];
            for (int j = 1; j <= k && i - j + 1 >= 0; j++) {
                // update the max as we increase the partition size
                max = Math.max(max, arr[i - j + 1]);
                int curMax = 0;
                // first bound check
                if (i - j >= 0) {
                    // here we check from maximum partition is till 0th index or not then get
                    // currentMaximum
                    // current maximum for any partition
                    // here length would be j
                    curMax = max * j + dp[i - j];

                } else {
                    curMax = max * j;
                }
                dp[i] = Math.max(dp[i], curMax);

            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 15, 14, 9, 2, 5, 10 };
        int k = 3;
        System.out.println(maxSumAfterPartitioning(arr, k));
    }
}