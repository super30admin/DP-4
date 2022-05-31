
// Time Complexity : O(n*k)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
 public int MaxSumAfterPartitioning(int[] arr, int k) {
        
    if(arr == null || arr.Length == 0 || k == 0)
        return 0;
    
    int[] dp = new int[arr.Length];
    dp[0] = arr[0];
    //Idea Is to store the maximum sum at every index, then use that max sum to calculate new sum for next index.
    for(int i = 1; i < arr.Length; i++)
    {
        //At ever point, we calculate all possible cases with most k element back
        //Then save maximum sum till that point, so that we can use for next element to calculate new max at next index
        int max = arr[i];
        for(int j = 1; j <= k && i -j + 1 >= 0; j++)
        {
            max = Math.Max(max, arr[i - j + 1]);
            if(i - j >= 0)
                //we multiply max with j(how many times we want to repeat this element) + maximum till j
                dp[i] = Math.Max(dp[i], max * j + dp[i - j]);
            else
                dp[i] = Math.Max(dp[i], max * j);
        }
    }
    
    return dp[arr.Length - 1];
}