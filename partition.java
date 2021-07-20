//Time complexity-O(nk)
//Space complexity-O(n)
//Ran on leetcode-Yes
//Solution with comments-
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if(arr.length==0)
            return 0;
        int dp[]= new int[arr.length];
        int max=-1;
        for(int i=0;i<k;i++){
            max=Math.max(arr[i],max);
            dp[i]=max*(i+1);//store the first k elemants highest values
        }
        for(int i=k;i<arr.length;i++){
            max=-1;
            for(int j=1;j<=k;j++){
                max=Math.max(arr[i-j+1],max);//check the max till from i till i-k
               
                dp[i]=Math.max(dp[i],(max*j)+dp[i-j]);//dp[i-j] contains the max achieved so far
            }
        }
        return dp[arr.length-1];
        
    }
}