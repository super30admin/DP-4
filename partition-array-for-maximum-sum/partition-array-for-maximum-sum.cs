public class Solution {
    public int MaxSumAfterPartitioning(int[] arr, int k) {
        if(arr.Length==0) return 0;
        
        int[] dp = new int[arr.Length];
        
        for(int i=arr.Length-1;i>=0;i--)
        {
            int? currvalue = null;
            int? max = null;
            for(int j=i;j<i+k && j<arr.Length;j++)
            {
                currvalue = (currvalue == null ?  arr[j] : Math.Max(currvalue.Value,arr[j]));
                int newpartition = currvalue.Value *(j-i+1) + (j!=arr.Length-1 ? dp[j+1] : 0);
                max = (max==null ? newpartition : Math.Max(newpartition,max.Value));
            }
            dp[i] = max.Value;
        }
        return dp[0];
        
    }
}
