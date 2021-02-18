//Time Complexity: o(n)
//Space Complexity: 0(n)
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int len = arr.length;
        int result = 0;
        if(arr.length == 0) return result;
        int dp[] = new int[len];
        for(int i =0; i<len; i++)
        {
            int j =1;
            int max = 0;
            while(j<=k && i-j+1 >=0)
            {
                max = Math.max(max, arr[i-j+1]);
                if(i-j >=0)
                {
                    dp[i] = Math.max(dp[i], dp[i-j]+max*j);
                }
                else
                {
                   dp[i]  = Math.max(max, j*max);
                }
                j++;
            }
        }
        return dp[len-1];
    }
}