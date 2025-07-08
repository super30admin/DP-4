import java.util.Arrays;

/* Bottom Up DP
Time Complexity - O(K * N)
Space complexity - O(N)
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
*/
public class PartitionArrayforMaximum_Sum_LC_1043 {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int dp[] = new int[arr.length];
        dp[0] = arr[0];
        for(int i = 1; i< arr.length; i++) {
            int max = arr[i];
            for(int j = 1; j<=k && i - j +1 >=0; j++) { //this is for boundary check (i - j >=0)
                int curr = arr[i - j +1];
                max = Math.max(max, curr);
                if(i-j >= 0) {
                    dp[i] = Math.max(dp[i], max * j + dp[i-j]);
                } else { // index lesser than i - j +1
                    dp[i] = Math.max(dp[i], max * j);
                }


            }
        }
        return dp[arr.length -1];

    }
}

/* Recursive / Exhaustive - gives TLE
Time Complexity - O(K ^ N)
Space complexity - O(N)
*/
class PartitionArrayforMaximum_SumRecursive {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        return helper(arr,k, 0);
    }
    private int helper(int arr[], int k, int idx) {
        //base case
        if(idx >= arr.length) return 0;

        //logic
        int max = 0;
        int maxPartition = arr[idx];
        for(int j = 1; j <= k && idx +j-1 < arr.length; j++) {
            maxPartition = Math.max(maxPartition, arr[idx + j-1]);  //this is incoming elements arr[idx - j+1]
            int curr = maxPartition * j + helper(arr,k , j+idx);
            max = Math.max(max, curr);
        }
        return max;
    }
}


/* Top Down DP - Memoization
Time Complexity - O(N*K)
Space complexity - O(N) - recursive stack and memo array storage
*/
class PartitionArrayforMaximum_SumTopDown {
    int [] memo;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        this.memo = new int[arr.length];
        Arrays.fill(memo, -1);
        return helper(arr,k, 0);
    }
    private int helper(int arr[], int k, int idx) {
        //base case
        if(idx >= arr.length) return 0;
        if(memo[idx] != -1) return memo[idx];

        //logic
        int max = 0;
        int maxPartition = arr[idx];
        for(int j = 1; j <= k && idx +j-1 < arr.length; j++) {
            maxPartition = Math.max(maxPartition, arr[idx + j-1]);  //this is incoming elements arr[idx - j+1]
            int curr = maxPartition * j + helper(arr,k , j+idx);
            max = Math.max(max, curr);
        }
        memo[idx] = max;
        return max;
    }
}
