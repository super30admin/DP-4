public class PartitionArrayForMaxSum {

    // Time Complexity :O(k + n) where  n is the length of arr
    // Space Complexity : O(k)
    // Did this code successfully run on Leetcode :yes
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if(arr == null || arr.length == 0 || k > arr.length){
            return 0;
        }

        int[] dp = new int[k];
        for(int i=1; i<=arr.length; i++){
            int maxContributor = 0;
            int maxTotalSum = 0;

            for(int subArrayLength = 1; subArrayLength <= k && i-subArrayLength >= 0; subArrayLength++){

                maxContributor = Math.max(maxContributor, arr[i - subArrayLength]);
                maxTotalSum = Math.max(maxTotalSum,  dp[(i - subArrayLength) % k] + (maxContributor * subArrayLength));
            }
            dp[i % k] = maxTotalSum;
        }
        return dp[arr.length % k]; // this is also important
    }

    // Time Complexity :O(k + n) where  n is the length of arr
    // Space Complexity : O(n)
    // Did this code successfully run on Leetcode :yes
    public int maxSumAfterPartitioningDP(int[] arr, int k) {
        if(arr == null || arr.length == 0 || k > arr.length){
            return 0;
        }
        int[] dp = new int[arr.length + 1];
        for(int i=1; i<=arr.length; i++){
            int maxContributor = 0;
            int maxTotalSum = 0;
            int currentSubArraySum = 0;

            for(int subArrayLength = 1; subArrayLength <= Math.min(i, k); subArrayLength++){
                maxContributor = Math.max(maxContributor, arr[i-subArrayLength]);
                currentSubArraySum = dp[i-subArrayLength] + (maxContributor * subArrayLength);
                maxTotalSum = Math.max(maxTotalSum, currentSubArraySum);
                dp[i] = maxTotalSum;
            }
        }
        return dp[arr.length];
    }




    // Time Complexity :O(k^n) where  n is the length of arr
    // Space Complexity : O(1)
    // Did this code successfully run on Leetcode :yes
    private int result;
    public int maxSumAfterPartitioningBruteForce(int[] arr, int k) {
        if(arr == null || arr.length == 0 || k > arr.length){
            return 0;
        }
        helper(arr, k, 0, 0);
        return result;
    }

    private void helper(int[] arr, int k, int idx, int totalSum){
        //base
        if(idx >= arr.length){
            result = Math.max(result, totalSum);
            return;
        }
        int currentSumArrayMax = 0;
        for(int i=0; i<k && idx+i < arr.length; i++){
            currentSumArrayMax = Math.max(currentSumArrayMax, arr[idx+i]);
            helper(arr, k, idx+i+1, totalSum + (currentSumArrayMax * (i+1)));
        }
    }

}
