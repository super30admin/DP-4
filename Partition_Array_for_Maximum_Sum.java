//Time Complexity : O(nk)
//Space Complexity : O(n)-> dp array
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int [] dp = new int[n];
        for(int i = 0; i < n; i++){
            //starting from each index take max 
            int max = arr[i];
            for(int j = 1; j <= k && i - j + 1 >= 0; j++){
                //max will be either earlier max or incoming element
                max = Math.max(max, arr[i - j + 1]);
                //bounds check
                if(i - j >= 0){
                //earlier dp or max* elements in partition + dp[i-j]-> max element on left of partioning 
                    dp[i] = Math.max(dp[i], (max*j) + dp[i-j]);
                }
                //
                else{
                    //if reached < 0 just max between earlier max dp and max* elements in partition
                    dp[i] = Math.max(dp[i], (max*j));
                }
            }
        }
        //last element in dp array will be having maximum sum after partioning 
        return dp[n-1];
    }
}