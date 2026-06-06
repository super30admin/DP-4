// Time Complexity : O(n * k) where n is the length of the array.
// Space Complexity : O(n) space for dp array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
    I create a dp array and assign it's first element to that of first element of arr. I then start traversing from the 1st index of the dp array and iterate starting from each element and move k steps
    back to form a partition. I keep track of the maximum element in the partition and also calculate the sum of that partition as maximum element * size of partition. I then update each element in the
    dp array with the maximum sum of all partitions that can be formed so far from that element.
*/

public class Solution
{
    public int MaxSumAfterPartitioning(int[] arr, int k)
    {
        int n = arr.Length;
        int[] dp = new int[n];
        dp[0] = arr[0];

        for (int i = 1; i < n; i++)
        {
            int max = 0;
            int count = 0;
            int sum = 0;

            for (int j = i; j >= 0 && count < k; j--)
            {
                max = Math.Max(max, arr[j]);
                sum = max * (count + 1);
                int previousSum = (i - (count + 1)) < 0 ? 0 : dp[i - (count + 1)];
                dp[i] = Math.Max(dp[i], sum + previousSum);
                count++;
            }
        }

        return dp[n - 1];
    }
}