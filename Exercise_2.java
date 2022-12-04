class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int [] dp = new int[arr.length+1];
        for(int start = arr.length-1; start>=0; --start){
            int max = 0;
            int ans = 0;
            for(int part = 1; part <= k && start+part<=arr.length; ++part){
                int end = start+part-1;

                max =Math.max(max, arr[end]);

                ans =Math.max(ans, max*part + dp[end+1]);
            }
            dp[start] = ans;
        }
        return dp[0];
    }
}
//t=
O(n)
//sc=O(n)
