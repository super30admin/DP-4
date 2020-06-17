// Time Complexity : O(n); n - number of elements in the array
// Space Complexity : O(n); n - number of elements in the array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
	1. Traverse every element in the array
	2. Determine  
			Single partition
			Double partition
			Triple partition
			.
			.
			K partition
		Paritions are created such that each parition ends at element at Step1
	3. Find maximum element for each partition in Step2
	4. dp[i] = Math.max(dp[i], dp[i-j] + max*j)
	5. Return last element in the dp array
*/

public class PartitionArrayForMaximumSum {
	//DP
	public int maxSumAfterPartitioning(int[] A, int K) {
		//edge
		if(A == null || A.length == 0)
			return 0;
		
		int[] dp = new int[A.length];
		int max = 0;
		
		for(int i = 0; i < A.length; i++) {
			max = 0;
			// i-j+1 >= 0 is used to find the element we are pressently considering
			for(int j = 1; i-j+1 >= 0 && j <= K; j++) {
				max = Math.max(max, A[i-j+1]);
				dp[i] = i >= j ? Math.max(dp[i], dp[i-j] + max*j) : Math.max(dp[i], max*j);
			}
		}
		return dp[A.length - 1];
	}
}