import java.util.Arrays;

public class PartitionArrayForMaximumSum {
    public static int maxSumAfterPartitioning(int[] arr, int k) { //O(n*k) T.C, O(n) S.C
        int n = arr.length;
        int[] dp = new int[n]; //dp array stores the max sum up until that index
        dp[0] = arr[0]; //the first value of dp is always the same as input array
        for(int i=1; i<n; i++) {
            int currPartitionMax = arr[i]; //On each iteration of a value in input, the current max
            for(int j=1; j<=k; j++) { //iteration on k
                if(i-j+1 >= 0) { //bound check, if i-k elements are inside the array or not
                    // update the current max if the value arr[i] or other value in subarray of k length is bigger
                    currPartitionMax = Math.max(currPartitionMax, arr[i-j+1]);
                    //after finding the current max, multiply it with current subarray size
                    int currSum = currPartitionMax * j;
                    if(i-j >= 0) { //only if the i-jth value is in the bounds of array
                        currSum += dp[i-j]; //add the previously calculated max value from out of current subarray bound
                    }
                    dp[i] = Math.max(dp[i], currSum); //now update the dp[i] on which subarray partition gave max value
                }
            }
        }
        return dp[n-1]; //the last value from the dp array is the max sum.
    }

    public static void main(String[] args) {
        int[] arr = {12, 3, 17, 5, 21, 2, 4};
        int k = 2;

        System.out.println("Maximum sum with at most " + k + " partitions from the given array " +
                Arrays.toString(arr) + " is: " + maxSumAfterPartitioning(arr, k));
    }
}
