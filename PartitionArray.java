import java.util.Arrays;

// Time Complexity:
// Space Complexity:
public class PartitionArray {
    // Time Complexity : O(k^n)
    public int maxSumAfterPartitioningRecursive(int[] arr, int k) {

        return helper(arr, 0, k);
    }

    private int helper(int[] arr, int pivot, int k){
        // base
        if(pivot == arr.length){
            return 0;
        }
        int max = 0;
        int result = 0;
        for(int i = pivot; i < pivot+k && i < arr.length; i++){
            max = Math.max(max, arr[i]);
            int currPartition = max*(i-pivot+1);
            int rest = helper(arr, i+1, k);
            result = Math.max(result, currPartition+rest);
        }

        return result;
    }

    // Memoization
    // Time Complexity : O(n*k)
    // Space Complexity : O(n)
    int[] memo;
    public int maxSumAfterPartitioningMemoization(int[] arr, int k) {
        this.memo = new int[arr.length];
        Arrays.fill(memo, -1);
        return helperMemoization(arr, 0, k);
    }

    private int helperMemoization(int[] arr, int pivot, int k){
        // base
        if(pivot == arr.length){
            return 0;
        }
        if(memo[pivot] != -1){
            return memo[pivot];
        }
        int max = 0;
        int result = 0;
        for(int i = pivot; i < pivot+k && i < arr.length; i++){
            max = Math.max(max, arr[i]);
            int currPartition = max*(i-pivot+1);
            int rest = helper(arr, i+1, k);
            result = Math.max(result, currPartition+rest);
        }

        memo[pivot] = result;
        return result;
    }

    // Dynamic Programing
    public int maxSumAfterPartitioningDP(int[] arr, int k) {
        int[] dp = new int[arr.length];

        dp[0] = arr[0];
        for(int i = 1; i < arr.length; i++){
            int max = 0;
            for(int j = 1; j <= k && i-j+1 >= 0; j++){
                max = Math.max(max, arr[i-j+1]);
                if(i-j < 0){
                    dp[i] = Math.max(dp[i], max*j);
                }else{
                    dp[i] = Math.max(dp[i], max*j + dp[i-j]);
                }
            }
        }
        return dp[arr.length-1];
    }
}
