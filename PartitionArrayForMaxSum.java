import java.util.Arrays;

/**
 * Leetcode 1043. Partition Array for Maximum Sum
 * Link: https://leetcode.com/problems/partition-array-for-maximum-sum/description/
 */
//------------------------------------ Solution 1 -----------------------------------
public class PartitionArrayForMaxSum {
    /**
     * Brute force exhaustive solution using recursion. Explore all possible partitions for each index and among those
     * possible partition keep/choose the maximum sum giving partition.
     *
     * TC: O(k^n)
     * Auxiliary SC: O(1)
     * Recursive stack SC: O(n)
     */
    public int maxSumAfterPartitioning(int[] arr, int k) {
        return helper(arr, k, 0);
    }

    private int helper(int[] arr, int k, int idx) {
        //base
        if (idx == arr.length){
            return 0;
        }

        //logic
        int max = 0;
        int maxPartition = 0; //max among idx to idx + k - 1 elements
        //explore options for all k partitions for the current idx
        for (int i = 1; i <= k && idx + i - 1 < arr.length; i++) {
            maxPartition = Math.max(maxPartition, arr[idx + i - 1]);
            int curr = maxPartition * i + helper(arr, k, idx + i); // max in partition * paritition length + recursion on rest
            max = Math.max(max, curr);
        }
        return max;
    }
}

//------------------------------------ Solution 2 -----------------------------------
class PartitionArrayForMaxSum2 {
    /**
     * Optimized DP solution from above exhaustive solution using memoization. once we find
     * maximum sum contribution from a given index we store the result in memo array which then will
     * save future calculations coming from unwinding recursive stack. memo will start to fill from
     * back for the given solution.
     *
     * TC: O(n*k)
     * Auxiliary SC: O(n) for memo array
     * Recursive stack SC: O(n)
     */
    int[] memo;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        this.memo = new int[arr.length];
        Arrays.fill(memo, -1);
        return helper(arr, k, 0);
    }

    private int helper(int[] arr, int k, int idx) {
        //base
        if (idx == arr.length){
            return 0;
        }

        //logic
        if (memo[idx] != -1) {
            return memo[idx];
        }
        int max = 0;
        int maxPartition = 0; //max among idx to idx + k - 1 elements
        //explore options for all k partitions for the current idx
        for (int i = 1; i <= k && idx + i - 1 < arr.length; i++) {
            maxPartition = Math.max(maxPartition, arr[idx + i - 1]);
            int curr = maxPartition * i + helper(arr, k, idx + i); // max in partition * paritition length + recursion on rest
            max = Math.max(max, curr);
        }
        memo[idx] = max;
        return max;
    }
}

//------------------------------------ Solution 3 -----------------------------------
class PartitionArrayForMaxSum3 {
    /**
     * Bottom up DP solution with tabulation 1D dp array. where for each element (i) in arr we run 1 to k partition; find
     * maximum among those each of the partitions; multiply that by current partition length (j) and add previously calculated
     * DP at i - j and update DP at i with maximum possible solution among all the 1 through k partitions.
     *
     * TC: O(nk)
     * SC: O(n)
     */
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];

        for (int i = 1; i < arr.length; i++){
            int max = 0;
            for (int j = 1; j <= k && i - j + 1 >= 0; j++) {
                //current element i - j + 1, previously calculated dp is i - j
                max = Math.max(max, arr[i - j + 1]); //starting with j = i till k each loop find maximum in current j partition
                if(i - j >= 0) {
                    dp[i] = Math.max(dp[i], max*j + dp[i - j]);
                } else { // for initial few i where partition itself reaches edge of arr and there is no dp[-1] available
                    dp[i] = Math.max(dp[i], max*j);
                }
            }
        }
        return dp[arr.length - 1];
    }
}