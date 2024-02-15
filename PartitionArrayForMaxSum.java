/*
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(n*k)
    n - elements in arr
    k - max size of window
* 
* Space Complexity: O(n)
* 
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class PartitionArrayForMaxSum {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;

        int dp[] = new int[n];

        int path[] = new int[n];

        for(int index = 0; index < n; index++){
            helper(arr, n, k, index, dp, path);
        }

        List<Integer> partitions = new ArrayList<>();

        int index = n-1;

        while(index >=0){
            partitions.add(index);
            
            index = index - path[index];
        }

        Collections.reverse(partitions);

        System.out.println(partitions);

        return dp[n-1];
    }

    private void helper(int[] arr, int n, int maxK, int pivot, int[] dp, int[] path){
        int maxElement = Integer.MIN_VALUE;

        for(int k = 1; k <= maxK && pivot-k+1 >=0; k++){
            maxElement = Math.max(maxElement, arr[pivot-k+1]);

            if(pivot-k>=0){
                if(dp[pivot] < dp[pivot-k] + k*maxElement){
                    dp[pivot] = dp[pivot-k] + k*maxElement;
                    path[pivot] = k;
                }
            } else {
                if(dp[pivot] < k*maxElement){
                    dp[pivot] = k*maxElement;
                    path[pivot] = k;
                }
            }
        }
    }
}