// Time complexity- O(m*n)
// Space complexity- O(n)
function maximalSquare(matrix: string[][]): number {
	const m = matrix.length;
	const n = matrix[0].length;
	// dp is a 1D array representing largest square side length of the next row
	const dp = Array.from({ length: n + 1 }, () => 0);

	let max = 0;
	// to track the bottom-right diagonal minimum dp[i+1][j+1]
	let diag = 0;
	for (let i = m - 1; i >= 0; i--) {
		for (let j = n - 1; j >= 0; j--) {
			// update dp if we cncounter "1"
			if (matrix[i][j] == "1") {
				const temp = dp[j];

				// largest square at (i, j) is 1 plus the minimum side length of its three neighbors
				//  dp[j]: largest square side at bottom cell dp[i+1][j]
				//  dp[j+1]: largest square side at right cell dp[i][j+1]
				//  diag: largest square side at bottom-right cell dp[i+1][j+1]
				dp[j] = 1 + Math.min(dp[j], dp[j + 1], diag);

				diag = temp;
				max = Math.max(max, dp[j]);
			} else {
				// if the cell is "0", max square side ending here is 0
				dp[j] = 0;
			}
		}
	}

	// return the area
	return max * max;
}
