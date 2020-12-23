/**
 * TC : O(n) SC : O(n)
 * Approach : Using sliding window technique, create window of size k, and update sum with the largest among th ewindow keep sum at that 
 *            index in the dp. 
 */
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        
        for(int i = 0; i < arr.length; i++){
            int max = arr[i];
            for(int j = 1; j <= k; j++){
                if(i-j+1 < 0) break;
                max = Math.max(max,arr[i-j+1]);
                if(i-j >= 0){
                    dp[i] = Math.max(dp[i],dp[i-j] + max*j);
                } else{
                    dp[i] = Math.max(dp[i], max*j);
                }
            }
        }
        return dp[arr.length-1];
    }
}