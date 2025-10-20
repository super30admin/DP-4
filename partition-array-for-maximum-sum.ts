// Time complexity: O(N * K), where N is the length of the array 'arr' and K is the partition limit
// Space complexity: O(N) for the auxiliary array 'dp'
function maxSumAfterPartitioning(arr: number[], k: number): number {
	// dp[i] stores the maximum sum achievable for arr[0...i]
	const dp = new Array(arr.length).fill(0);
	dp[0] = arr[0];

	// iterate through the array to calculate max sum ending at index i
	for (let i = 1; i < arr.length; i++) {
		// tracks the maximum possible total sum found for arr[0...i]
		let totalMax = 0;

		// tracks the maximum element within the current partition arr[i-j+1...i]
		let maxInPart = 0;

		// loop through all possible partition lengths 'j' (from 1 up to K) ending at 'i'
		for (let j = 1; j <= k && i - j + 1 >= 0; j++) {
			// the starting index of the current partition of size 'j' is i - j + 1
			const currentElement = arr[i - j + 1];

			// update the max element found so far in the current partition
			maxInPart = Math.max(maxInPart, currentElement);

			// calculate the score for the current partition: (max element) * (partition size j)
			let currentPartToal = maxInPart * j;

			// if a preceding segment exists (i - j >= 0), add the maximum sum from that part
			if (i - j >= 0) {
				// total sum = score of current partition + max sum of the previous partition (dp[i-j])
				currentPartToal = currentPartToal + dp[i - j];
			}

			// update the overall maximum sum for dp[i] by checking all partition lengths j
			totalMax = Math.max(totalMax, currentPartToal);
		}
		// update the max possible sum at i
		dp[i] = totalMax;
	}

	return dp[arr.length - 1];
}
