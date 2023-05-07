/*
Time complexity - O(N * K) 
Space complexity - O(N) where N is the length of the array arr and K is input partition length.
 */
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int K) {
        
        int N = arr.length;
        int[] maxSum = new int[N + 1];

        for(int i = 0; i <= arr.length; i++){
            int maxEle = 0, sum = 0;
            for(int k = 1; k <= K && i - k >= 0; k++){
                maxEle = Math.max(maxEle, arr[i - k]);
                sum = Math.max(sum, maxSum[i - k] + maxEle * k);
            }
            maxSum[i] = sum;
            System.out.print(maxSum[i] + " ");
        }
        return maxSum[N];
    }
}
