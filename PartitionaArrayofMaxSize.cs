using System;
using System.Collections.Generic;
using System.Text;

namespace DP
{
    class PartitionArrayofMaxSizeLC
    {
        //TC:O(n*k)
        //SC:O(n)
        public int MaxSumAfterPartitioning(int[] arr, int k)
        {
            int arraySize = arr.Length;
            int[] dp = new int[arraySize];

            int max = arr[0];
            for (int i = 1; i < k; i++)
            {
                max = Math.Max(max, arr[i]);
                dp[i] = max * (i + 1);
            }
            int partitionMax;
            for (int i = k; i < arraySize; i++)
            {
                partitionMax = arr[i];
                //traversing all combinations
                for (int partitionSize = 1; partitionSize <= k; partitionSize++)
                {
                    partitionMax = Math.Max(partitionMax, arr[i - partitionSize + 1]);
                    dp[i] = Math.Max(dp[i - partitionSize] + (partitionMax * partitionSize), dp[i]);
                }
            }
            return dp[arraySize - 1];
        }
    }
}
