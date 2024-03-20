package week9.day1;
//TC - O(n)
//SC - O(n)
class Solution26 {
	public int maxSumAfterPartitioning(int[] arr, int k) {
		int[] dp = new int[arr.length];
		dp[0] = arr[0];
		int maxSum = dp[0];
		for (int i = 1; i < arr.length; i++) {
			int j = i;
			int maxValue = arr[i];
			int loop = 1;
			while (loop <= k && j >= 0) {
				maxValue = Math.max(maxValue, arr[j]);
				int option = maxValue * loop;
				j--;
				if (j >= 0)
					option += dp[j];
				loop++;
				maxSum = Math.max(option, maxSum);
			}
			dp[i] = maxSum;
		}

		return dp[dp.length - 1];
	}
}

public class MaxSumAfterPartitioning {

	public static void main(String[] args) {
		int[] arr = { 1, 15, 7, 9, 2, 5, 10 };
		int k = 3;
		Solution26 s = new Solution26();
		System.out.println(s.maxSumAfterPartitioning(arr, k));

	}

}
