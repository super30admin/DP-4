/*
The following approach utilizes a bottom-up DP matrix to solve the problem. At each location in the
array, the maximum partition sum uptil that location is calculated, and the used to calculate further
maximum partition sums for all the locations ahead of it, such that at the end of the array we have the
final maximum partition sum. The following steps are taken to calculate the maximal sum at each location:

1. We start by taking the single element at that location itself as the first partition, and using previously
computed results for maximum sum, we add its value to the max sum at the location before the current location.
2. We then increase the partition window by adding the element before the current element to the partition, taking
the maximum among those elements, and then again repeat the process by calculating using the max sum before the
current partition.
3. This process is repeated till we hit the limit K for size of partition for each location.

Did this code run on leetcode: Yes
*/
class Solution {
    //Time Complexity: O(n*k)
    //Space Complexity: O(n)
    public int maxSumAfterPartitioning(int[] arr, int k) {
        
        int n = arr.length;
        int[] dp = new int[n];
        
        if(n == 1)
            return arr[0];
        
        int max = 0;
        int curr = 0;
        //For the first location the max sum will always be the element at that location
        dp[0] = arr[0];
        
        for(int i = 1; i < n; i++)
        {   //We set the maximum element to the one at the current location initially, as we have a single partition
            max = arr[i];
            for(int j = 1; j <= k && i - j + 1 >= 0 ; j++)
            {   //As we increase the partition size we again check for max element within the partition
                max = Math.max(max, arr[i - j + 1]);
                //For calculating the max sum, we use the previously computed max sums before the current partition
                if(i - j >= 0)
                    curr = j * max + dp[i - j];
                else
                    curr = j * max;
                //The maximum max sum after calculating all the partitions is stored in the DP array as the max sum till that location
                dp[i] = Math.max(dp[i], curr);
            }
           
        }
        return dp[n - 1];
    }
}