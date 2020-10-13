//Time Complexity: O(nk) each time we are going k stpes backward
//space Complexity: O(n)
//Did it run on leetcode: yes

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        
        for(int i=1; i<dp.length; i++){
            int max = Integer.MIN_VALUE;
            for(int j=1; j<=k && i-j+1>=0; j++){
                max = Math.max(max, arr[i-j+1]);
                if(i-j<0)
                    dp[i] = Math.max(dp[i], max*j);
                else
                    dp[i] = Math.max(dp[i], dp[i-j]+max*j);
            }
        }
        
        return dp[dp.length-1];
    }
}
