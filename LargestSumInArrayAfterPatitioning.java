class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
       //Time Complexity:O(n*k) 
       //Space Complexity:O(n) 
        int maxRes = 0;
        int[] dp = new int [arr.length];
        dp[0] = arr[0];
        for (int i =1;i < arr.length;i++){
            int curMax = arr[i];
            int curSum = curMax;
            int j = i-1;
            int curK = k-1;

            curSum = curMax + dp [i-1];
            // traverse for every k and get a max
            while (curK > 0 && j>=0) {

            curMax = Math.max(curMax,arr[j]);
            int num = i-j+1;
            int insideSum = curMax * num;
            int outsideSum = j > 0 ? dp[j-1] : 0;
            curSum = Math.max (curSum,insideSum + outsideSum);
            curK--;
            j--;
            }
            dp[i] = curSum;
        }
        return dp[arr.length-1];
    }
}
