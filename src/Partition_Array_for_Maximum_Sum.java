//Time Complexity : O(nK)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**for j between 0 and K, we can partition with the indices (i-j,j), if we partition like this, then max is in that window times the size of that window
 * with that result, we add to the optimal partitions value until index i-j+1
 * repeat for each k and keep the max as the value at that case*/

public class Partition_Array_for_Maximum_Sum {
	public int maxSumAfterPartitioning(int[] A, int K) {
		if(A == null || A.length == 0)
			return 0;

		int[] dp = new int[A.length];
		for(int i=0; i<A.length; i++){
			int max = A[i];
			for(int j=1; i-j+1 >=0 && j <= K; j++){ //j is splits,  iterate till max split possible
				max = Math.max(max, A[i-j+1]);  //updating max with each incoming values

				if(i >= j)
					dp[i] = Math.max(dp[i], dp[i-j] + max * j);  //find value by taking value k splits previous to i and adding k times the max value from the values in split
				else    
					dp[i] = Math.max(dp[i] , max * j);  // else  k times the max value from the values in split
			}
		}
		return dp[dp.length-1];
	}
}
