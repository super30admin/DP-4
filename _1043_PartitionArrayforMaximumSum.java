// Time Complexity : o(n*k) size of array
// Space Complexity :  o(n) size of array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: two option partiotion or not after each eelmet for window size k
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int dp[] = new int[arr.length];
        Arrays.fill(dp, -1);
        return helper(arr, k, 0, dp);
    }

    public int helper(int[] arr, int k , int index, int[] dp){
        if(index >= arr.length) return 0;

        if(dp[index] != -1) return dp[index];

        int max = arr[index];
        int sum  = 0;

        for( int i = 1; i<=k && index+i <= arr.length; i++){
            int partition = max * i + helper(arr, k , index+i, dp);
            sum =  Math.max(sum, partition);
            if(index+i < arr.length)
                max = Math.max(max, arr[index+i]);
        }

        dp[index] = sum;

        return sum;
    }
}

//BOttom-up
public int maxSumAfterPartitioning(int[] arr, int k) {

        int[] dp = new int[arr.length];

        int max = Integer.MIN_VALUE;
        for(int i=0; i<k; i++){
            max = Math.max(max, arr[i]);
            dp[i] = max*(i+1);
        }

        for(int i=k; i<arr.length; i++){

            dp[i] = Integer.MIN_VALUE;
            int maxSOFar = arr[i];

            for(int j=1; j<=k; j++){
                int partition = maxSOFar*j + dp[i-j];
                dp[i] = Math.max(dp[i], partition);
                maxSOFar = Math.max(maxSOFar, arr[i-j]);
            }
        }

        return dp[arr.length-1];
    }
