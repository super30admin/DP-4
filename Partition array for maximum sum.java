// Time Complexity : O(nk)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
// We will keep a pointer from the start and find the maximum sum that can be returned by all the possible partitions. 
// When we move the pointer, we would have already found the maximum sum for the previous range. For every range we need to find maximum sum returned.


class Solution {
    
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if(arr == null || arr.length==0) return 0;
        int n=arr.length;
        int []dp=new int[n];
        dp[0]=arr[0];
        //this is the pointer in the array
        for(int i=0;i<n;i++)
        {
            int currMax=arr[i]; //the current value is taken as the maximum one
            // This is to find the maximum value through each partition
            //j should be less than equal to k and we can have k number of partitions only when the index>k i.e number of partitions needed. In this case it is j
            for(int j=1;j<=k && i+1-j>=0;j++)    
            {
            //to find the maximum value in the partition, we just need to the current value with the incoming value
                currMax=Math.max(currMax,arr[i+1-j]);
                //if the index of the current value - number of partitions is greater than 0
                if(i-j>=0)
                {
                    //in every partition the sum is maximum value*the length of the partition
                    dp[i]=Math.max(dp[i], (currMax*j)+dp[i-j]); //dp[i-j] is the remaining range before the partition
                }
                else
                {
                    //if the partions are greater than the length of the range
                    dp[i]=Math.max((currMax*j),dp[i]);  //currMax num * partition
                }
            }
        }
        return dp[n-1];
    }
}