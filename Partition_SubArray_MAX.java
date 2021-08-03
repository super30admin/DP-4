class Solution {
    //Time O(NK)
    //Space O(N)
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if(arr == null || arr.length == 0)
        {
            return 0;
        }
        int n = arr.length;
        int DP[] = new int[n];
        DP[0] = arr[0];
        for(int i = 1 ; i < n ; i++)
        {
            int max = arr[i];
            for(int j = 1 ; j <= k && i-j+1 >=0 ; j++)
            {
                max = Math.max(max , arr[i-j+1]);
                if(i-j >= 0) 
                {
                   DP[i] = Math.max(DP[i] , (max*j) + DP[i-j]);
                }
                else
                {
                    DP[i] = Math.max(DP[i] , max*j);
                }
            }
        }
        return DP[n-1];
    }
}