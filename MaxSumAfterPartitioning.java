/*
Time Complexity: O(N*k) K is dp state and N is the array length
Space Complexity: O(N) memoization array length
Run on complexity: yes
Any difficulties: no
Approach:
1. Recursion with memoization
2. I will be partitioning the given array in at Most K parts in the recursive method, and I am trying to process
every sub part, in order to maximize the sum
 */

class Solution{
    
    public static int maxSumAfterPartitioning(int [] arr, int k){
        return recursivePartition(arr, k, 0, new int[arr.length]);
    }

    public static int recursivePartition(int[] arr, int k, int start, int[] memo){
        // base case
        if(start>= arr.length){
            return 0;
        }
        if(memo[start]!= 0){
            return memo[start];
        }
        int maxNumber = 0; // suppose the maximum number as 0, I will update the maximum number while iteration using Math.max
        int maxSum = 0; // initially the maxSum would be zero, have to calculate the sum recursively

        for(int i = start; i<Math.min(arr.length, start+k); i++){
            maxNumber = Math.max(maxNumber, arr[i]);
            // recursive call to get the maximum sum for the index  (i-start+1) is the length of the partition
            maxSum = Math.max(maxSum, recursivePartition(arr, k, i+1, memo)+(i-start+1)*maxNumber);
        }
        memo[start] = maxSum;

        return maxSum;
    }
}
