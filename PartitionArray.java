// This solution uses dynamic programming (tabulation) based approach where we will calculate the small problem i.e., in the first index and keep building the max sum at every index by partitioning all the index-k partitions.
// At the end we will have the max partition array at last index
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        for(int i=1;i<arr.length;i++) {
            int currMax = 0;
            for(int j=0;j<k && (i-j)>=0;j++) {
                int index = i-j;
                currMax = Math.max(currMax, arr[index]);
                if(index-1>=0) {
                    dp[i] = Math.max(((j+1)*currMax+dp[index-1]), dp[i]);
                } else {
                    dp[i] = Math.max(((j+1)*currMax), dp[i]);
                }
            }
        }
        return dp[arr.length-1];
    }
}
