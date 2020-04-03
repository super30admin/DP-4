// Time Complexity : O(A*K)
// Space Complexity : O(A)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : DP IS HARD

/**
 * @param {number[]} A
 * @param {number} K
 * @return {number}
 */
var maxSumAfterPartitioning = function(A, K) {
    if (!A || !A.length) return 0;
    if (!K) return 0;
    
    const N = A.length;
    const gain = new Array(N).fill(0);

    for (let i = 0; i < N; i++) {
        let maxElement = 0;
        for (let j = 1; j <= K; j++) {
            if (i - j + 1 >= 0) {
                maxElement = Math.max(maxElement, A[i - j + 1]);
                gain[i] = Math.max(gain[i], j * maxElement + (i - j >= 0 ? gain[i - j] : 0));
            }
        }
    }
    return gain[N - 1];
};
