class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if(arr == null || arr.length == 0) return 0; //if arr is null or the length of the array is 0, then return 0
        int[] dp = new int[arr.length]; //we create an integer array with name dp of length arr.
        dp[0] = arr[0]; //we capture the value of arr[0] to the 0th index of the dp array
        for(int i = 1; i < arr.length; i++) { //we iterate through the length of the array starting from 1
            int max = arr[i]; // we store that value we get from i of the arr to the integer variable that we have created with name max
            for(int j = 1; j <= k && i - j + 1 >=  0; j++) { // we go with another iteration from 1 until it reaches k which is 3
                max = Math.max(max, arr[i - j + 1]); //we update the value of max by comparing it with the present max and the arr[i - j + 1]
                if(i - j >= 0) { //if i - j is greater than or equal to 0
                    dp[i] = Math.max(dp[i], max * j + dp[i - j]); // we find the max value of dp[i] by comparing it with previous dp[i] and max * j which is added to dp[i-j]
                }
                else { //if i - j is negative
                    dp[i] = Math.max(dp[i], max * j); //we find the max value of dp[i] by comparing it with previous dp[i] and max * j
                }
            }
        }
        return dp[arr.length - 1]; // in the end we return the dp array
    }
}
//tc and sc - o(nk) and o(n)