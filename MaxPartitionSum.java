// Time Complexity : O(nk) //n is the array length, k is the input
// Space Complexity : O(n)//dp array size
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
 * 1. you can select partition of size 1,2...k.
 * 2. at each element find sub partition max possible sum and with previous partition max sum
 */

public class MaxPartitionSum {
	public int maxSumAfterPartitioning(int[] arr, int k) {
		if(arr==null || arr.length<1) return 0;
		
		int[] dp=new int[arr.length];
		
		//when include first element only max value is element value
		dp[0]=arr[0];
		
		for(int i=1;i<dp.length;i++) {
			//when include only that element that is the max value
			int max=arr[i];
			for(int j=1;j<=k;j++) {
				
				if(i-j+1>=0) {
					//get largest element from the set of k.
					max=Math.max(max, arr[i-j+1]);
					if(i-j>=0) {
						dp[i]=Math.max(dp[i], dp[i-j]+max*j);
					}else {
						dp[i]=Math.max(dp[i], max*j);
					}
				}
			}
		}
		return dp[arr.length-1];
	}
}
