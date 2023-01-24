/*

We will use the bottom up DP to solve this problem,
We will choose a pivot and keep decreasing it till we have k elements in range
Since we already had previosly calculated the sums, we will use DP to solve that
*/

class Solution {
    // Time : O(n*k) Space: O(n)
    public int maxSumAfterPartitioning(int[] arr, int k) {

        int[] dp = new int[arr.length]; // we will use this to get the previously calculated value

        dp[0] = arr[0]; // Each index would represent the max sum at that index, so for 0 its the only one

        for(int i=1;i<arr.length;i++){ // this would pick the pivot / action element
        int j=i; // we will pick the pivot and keep on increasing the window at most k times going back 
        int count =k;
        int maxRes = Integer.MIN_VALUE; // Running Max Result
        int maxNum = Integer.MIN_VALUE; // Running Max Number
        while(j>=0 && count >0){
            maxNum = Math.max(maxNum, arr[j]); // taking the max number in the current window
            if(j>0){
            maxRes = Math.max(maxRes , maxNum * (i - j +1) + dp[j-1]); // The max sum at action item plus previous to that i.e bottom up
            }
            else{
                maxRes = Math.max(maxRes , maxNum * (i - j +1)); // when j ==0 , so no prev element
            }

            j--; // decrease the window
            count--; // decrease the count
        }
        dp[i] = maxRes;  // at the ith index, we would store max sum possible

        }                
        return dp[dp.length-1]; // the last element would contain the maximum ,sum as till that time the maximum size of the array considered
    }
}