// TC : O(n^2)
// SC : O(n)
// Ran on LC : Yes
// Problems : None.

class Solution {
	public int maxSumAfterPartitioning(int[] A, int K) {
		 int[] memo = new int[A.length];
		 memo[0] = A[0];
		 int initMax = A[0];

		 for(int i = 1; i < K; ++i) {
			  if (A[i] > initMax) {
					initMax = A[i];
			  }
			  memo[i] = (i+1) * initMax;
		 }

		 for (int i = K; i < A.length; ++i) {
			  int cur = 0;
			  int kIntervalMax = A[i];
				for (int j = 1; j <= K; ++j) {
						if (A[i-j+1] > kIntervalMax) {
								kIntervalMax = A[i-j+1];
							}
							cur = memo[i-j] + j * kIntervalMax;

							if (cur > memo[i]) {
								memo[i] = cur;
							}
					}
				}
		 return memo[A.length-1];
	}
}