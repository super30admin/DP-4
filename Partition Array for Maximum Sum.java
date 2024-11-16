//check for greedy, taking k size groups then choosing max and adding will not always give bigger num


//dp- n^2
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];

        dp[0] = arr[0];//getting first value

        for(int i =0; i <n; i++){
            int currMax = arr[i];//taking this value to keep track of the max value in partition
            for(int j = 1; j<=k && i-j+1 >=0 ; j++){//dividing partitions, starting from j = 1  to k, to keep
            //from going out of bouce checking if i-j+1>=0
                currMax = Math.max(currMax, arr[i - j + 1]);//keeping track of max value from each partition
                if(i - j >= 0){// check out of bounce
                    dp[i] = Math.max(dp[i], currMax * j + dp[i-j]);//adding max value  to dp, 
                    //currmax times the len of partirion plus remaining ele max sum from previous dp
                }else{
                    dp[i] = Math.max(dp[i], currMax * j);//in case no previous ele or out of bounce condition
                }
            } 
        }
        return dp[n-1];
    }
}