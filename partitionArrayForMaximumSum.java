package DataStructure.DynamicProgramming;

// Time Complexity : Add : O(N*k)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class PartitionArrayForMaximumSum {
    public static void main(String[] args) {
        int[] arr = {1,15,7,9,2,5,10};
        int k = 3;
        maxSumAfterPartitioning(arr, k);
    }

    public static int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];

        dp[0] = arr[0]; //assigning first element to dp first element

        for(int i=1; i<dp.length; i++){  // T.C - O(n * k), S.C - O(n)
            int max = dp[i];
            for(int j=1; j<=k; j++){  // traverse backwards to partition times (K)
                if(i-j +1 >= 0){
                    max = Math.max(max, arr[i-j+1]); // maintain the max value w.r.t arr element
                    if(i-j>=0)
                        dp[i] = Math.max(dp[i], dp[i-j] + max*j);
                    else
                        dp[i] = Math.max(dp[i], max*j);  // for the first K elements, unable to add dp[i-j] due to out of bounds
                }
            }
        }

        return dp[dp.length-1];
    }
}

